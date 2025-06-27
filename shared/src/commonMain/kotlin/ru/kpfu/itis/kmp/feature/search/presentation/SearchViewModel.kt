package ru.kpfu.itis.kmp.feature.search.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByAuthorUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByTitleUseCase
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SendFirebaseEventUseCase

class SearchViewModel : BaseViewModel<SearchViewState, SearchAction, SearchEvent>(
    initState = SearchViewState()
), KoinComponent {
    private val searchBooksByTitleUseCase: SearchBooksByTitleUseCase by inject()
    private val searchBooksByAuthorUseCase: SearchBooksByAuthorUseCase by inject()
    private val searchBooksByGenreUseCase: SearchBooksByGenreUseCase by inject()
    private val sendFirebaseEventUseCase: SendFirebaseEventUseCase by inject()

    override fun obtainEvent(event: SearchEvent) {
        when(event) {
            is SearchEvent.UpdateSearch -> updateSearch(event.search)
            is SearchEvent.Search -> search()
            is SearchEvent.SelectFilter -> selectFilter(event.filter)
            is SearchEvent.ClickToBook -> clickToBook(event.id)
            is SearchEvent.OpenScreen -> openScreen()
        }
    }

    private fun openScreen() {
        viewModelScope.launch {
            sendFirebaseEventUseCase(
                FirebaseEvent(
                    name = FirebaseEvent.NAME_OPEN_SCREEN,
                    params = mapOf(FirebaseEvent.PARAM_SCREEN_NAME to SCREEN_NAME)
                )
            )
        }
    }

    private fun clickToBook(id: String) {
        sendAction(SearchAction.NavigateToBook(id))
    }

    private fun selectFilter(filter: Filter) {
        viewState = viewState.copy(selectedFilter = filter)
    }

    private fun search() {
        if (viewState.search.isBlank()) {
            sendAction(SearchAction.ShowEmptySearchError)
            return
        }

        viewModelScope.launch {
            runCatching {
                viewState = viewState.copy(isLoading = true)
                when(viewState.selectedFilter) {
                    Filter.Title -> searchBooksByTitleUseCase(viewState.search)
                    Filter.Author -> searchBooksByAuthorUseCase(viewState.search)
                    Filter.Genre -> searchBooksByGenreUseCase(viewState.search)
                }
            }
                .onSuccess { books ->
                    viewState = viewState.copy(books = books, isLoading = false)
                }
                .onFailure {
                    viewState = viewState.copy(isLoading = false)
                    sendAction(SearchAction.ShowInternetConnectionError)
                }
        }
    }

    private fun updateSearch(search: String) {
        viewState = viewState.copy(search = search)
    }

    fun getViewStates(): CommonStateFlow<SearchViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<SearchAction> = actions.asCommonFlow()

    companion object {
        private const val SCREEN_NAME = "search"
    }
}
