package ru.kpfu.itis.kmp.feature.bookmarks.presentation

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
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.GetBookmarksUseCase
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.SendFirebaseEventUseCase

class BookmarksViewModel : BaseViewModel<BookmarksViewState, BookmarksAction, BookmarksEvent>(
    initState = BookmarksViewState()
), KoinComponent {
    private val getBookmarksUseCase: GetBookmarksUseCase by inject()
    private val sendFirebaseEventUseCase: SendFirebaseEventUseCase by inject()

    init {
        loadBooks()
    }

    override fun obtainEvent(event: BookmarksEvent) {
        when(event) {
            is BookmarksEvent.ClickToBook -> clickToBook(event.id)
            is BookmarksEvent.LoadBooks -> loadBooks()
            is BookmarksEvent.OpenScreen -> openScreen()
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

    private fun loadBooks() {
        viewModelScope.launch {
            runCatching { getBookmarksUseCase() }
                .onSuccess {
                    viewState = viewState.copy(books = it)
                }
                .onFailure {
                    sendAction(BookmarksAction.ShowBookmarksLoadingError)
                }
        }
    }

    private fun clickToBook(id: String) {
        sendAction(BookmarksAction.NavigateToBook(id))
    }

    fun getViewStates(): CommonStateFlow<BookmarksViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookmarksAction> = actions.asCommonFlow()

    companion object {
        private const val SCREEN_NAME = "bookmarks"
    }
}
