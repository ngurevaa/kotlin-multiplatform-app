package ru.kpfu.itis.kmp.feature.bookdetails.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.DeleteBookmarkUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.SaveBookmarkUseCase

class BookDetailsViewModel() : BaseViewModel<BookDetailsViewState, BookDetailsAction, BookDetailsEvent>(
    initState = BookDetailsViewState()
), KoinComponent {
    private val getBookDetailsUseCase: GetBookDetailsUseCase by inject()
    private val saveBookmarkUseCase: SaveBookmarkUseCase by inject()
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase by inject()

    private var currentBook: Book? = null

    override fun obtainEvent(event: BookDetailsEvent) {
        when(event) {
            is BookDetailsEvent.LoadBook -> loadBook(event.id)
            is BookDetailsEvent.ClearBook -> clearBook()
            is BookDetailsEvent.SaveBookmark -> saveBookmark()
            is BookDetailsEvent.DeleteBookmark -> deleteBookmark()
        }
    }

    private fun deleteBookmark() {
        viewModelScope.launch {
            runCatching { currentBook?.let { deleteBookmarkUseCase(it.id) } }
                .onSuccess {
                    viewState = viewState.copy(isBookmarked = false)
                }
                .onFailure {
                    sendAction(BookDetailsAction.ShowBookmarkSavingError)
                }
        }
    }

    private fun saveBookmark() {
        viewModelScope.launch {
            runCatching { currentBook?.let { saveBookmarkUseCase(it) } }
                .onSuccess {
                    viewState = viewState.copy(isBookmarked = true)
                }
                .onFailure {
                    sendAction(BookDetailsAction.ShowBookmarkSavingError)
                }
        }
    }

    private fun clearBook() {
        viewState = viewState.copy(isLoading = true, isBookmarked = false)
    }

    private fun loadBook(id: String) {
        viewModelScope.launch {
            runCatching {
                getBookDetailsUseCase(id)
            }
                .onSuccess { book ->
                    currentBook = book

                    viewState = viewState.copy(
                        name = book.name,
                        author = book.author,
                        image = book.image,
                        overview = book.overview,
                        isBookmarked = book.isBookmarked,
                        isLoading = false
                    )
                }
                .onFailure {
                    sendAction(BookDetailsAction.ShowInternetConnectionError)
                }
        }
    }

    fun getViewStates(): CommonStateFlow<BookDetailsViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookDetailsAction> = actions.asCommonFlow()
}
