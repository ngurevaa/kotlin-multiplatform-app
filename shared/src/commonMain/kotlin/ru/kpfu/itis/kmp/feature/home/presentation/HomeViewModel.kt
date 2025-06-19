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
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginAction
import ru.kpfu.itis.kmp.feature.home.domain.model.Book
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
                    viewState = viewState.copy(genres = genres)
                }

//            for (genre in viewState.genres) {
//                runCatching { getBooksByGenreUseCase(genre) }
//                    .onSuccess {
//                        val books = viewState.books.toMutableMap()
//                        books.put(genre, it)
//                        viewState = viewState.copy(books = books)
//                    }
//                    .onFailure {
//                        sendAction(HomeAction.ShowInternetConnectionError)
//                    }
//            }

            runCatching { getBooksByGenreUseCase(viewState.genres[0]) }
                .onSuccess {
                    val books = viewState.books.toMutableMap()
                    books.put(viewState.genres[0], it)
                    viewState = viewState.copy(books = books)
                }
                .onFailure {
                    sendAction(HomeAction.ShowInternetConnectionError)
                }
        }
    }

    override fun obtainEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.ClickToBook -> clickToBook(event.id)
        }
    }

    private fun clickToBook(id: String) {
        sendAction(HomeAction.NavigateToBook(id))
    }

    fun getViewStates(): CommonStateFlow<HomeViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<HomeAction> = actions.asCommonFlow()
}
