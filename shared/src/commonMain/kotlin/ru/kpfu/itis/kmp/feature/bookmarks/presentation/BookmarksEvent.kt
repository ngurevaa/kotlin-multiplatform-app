package ru.kpfu.itis.kmp.feature.bookmarks.presentation

sealed class BookmarksEvent {
    data object LoadBooks : BookmarksEvent()
    data class ClickToBook(val id: String) : BookmarksEvent()
}
