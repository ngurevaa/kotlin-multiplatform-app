package ru.kpfu.itis.kmp.feature.home.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksByGenreUseCase
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

class HomeViewModel : BaseViewModel<HomeViewState, HomeAction, HomeEvent>(
    initState = HomeViewState()
), KoinComponent {
    private val getGenresUseCase: GetGenresUseCase by inject()
    private val getBooksByGenreUseCase: GetBooksByGenreUseCase by inject()

    init {
        viewModelScope.launch {
            runCatching { getGenresUseCase() }
                .onSuccess { genres ->
                    viewState = viewState.copy(
                        genres = genres,
                        currentGenre = genres[0]
                    )
                    loadBooksByCurrentGenre()
                }
        }
    }

    override fun obtainEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.ClickToBook -> clickToBook(event.id)
            is HomeEvent.UpdateCurrentGenre -> updateCurrentGenre(event.genre)
        }
    }

    private fun updateCurrentGenre(genre: Genre) {
        viewState = viewState.copy(currentGenre = genre)

        viewModelScope.launch {
            loadBooksByCurrentGenre()
        }
    }

    private fun clickToBook(id: String) {
        sendAction(HomeAction.NavigateToBook(id))
    }

    private suspend fun loadBooksByCurrentGenre() {
        runCatching {
            viewState = viewState.copy(isLoading = true)
            getBooksByGenreUseCase(viewState.currentGenre)
        }
            .onSuccess { books ->
                viewState = viewState.copy(
                    isLoading = false,
                    books = viewState.books.toMutableMap().apply { put(viewState.currentGenre, books) }
                )
            }
            .onFailure {
                viewState = viewState.copy(isLoading = false)
                sendAction(HomeAction.ShowInternetConnectionError)
            }
    }

    fun getViewStates(): CommonStateFlow<HomeViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<HomeAction> = actions.asCommonFlow()
}
