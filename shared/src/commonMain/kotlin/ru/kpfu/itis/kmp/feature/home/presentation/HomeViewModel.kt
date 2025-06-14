package ru.kpfu.itis.kmp.feature.home.presentation

import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
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
                .onFailure {
                    // action show error
                }

//            val list = listOf<Book>(
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//                Book("title", "author", "http://books.google.com/books/content?id=bIZiAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"),
//            )
//            viewState = viewState.copy(books = mapOf(viewState.genres[0] to list))
            for (genre in viewState.genres) {
                runCatching { getBooksByGenreUseCase(genre) }
                    .onSuccess {
                        val books = viewState.books.toMutableMap()
                        books.put(genre, it)
                        viewState = viewState.copy(books = books)
                    }
                    .onFailure {
                        // action show error about internet connection
                    }
            }
        }
    }

    override fun obtainEvent(event: HomeEvent) {

    }

    fun getViewStates(): CommonStateFlow<HomeViewState> = viewStates.asCommonStateFlow()
}
