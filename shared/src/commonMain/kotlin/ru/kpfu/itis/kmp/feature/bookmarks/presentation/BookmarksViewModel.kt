package ru.kpfu.itis.kmp.feature.bookmarks.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.GetBookmarksUseCase

class BookmarksViewModel : BaseViewModel<BookmarksViewState, BookmarksAction, BookmarksEvent>(
    initState = BookmarksViewState()
), KoinComponent {
    private val getBookmarksUseCase: GetBookmarksUseCase by inject()

    init {
        loadBooks()
    }

    override fun obtainEvent(event: BookmarksEvent) {
        when(event) {
            is BookmarksEvent.ClickToBook -> clickToBook(event.id)
            is BookmarksEvent.LoadBooks -> loadBooks()
        }
    }

    private fun loadBooks() {
        viewModelScope.launch {
            runCatching { getBookmarksUseCase() }
                .onSuccess {
                    viewState = viewState.copy(books = it)
                }
                .onFailure {

                }
        }
    }

    private fun clickToBook(id: String) {
        sendAction(BookmarksAction.NavigateToBook(id))
    }

    fun getViewStates(): CommonStateFlow<BookmarksViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookmarksAction> = actions.asCommonFlow()
}
