package ru.kpfu.itis.kmp.feature.bookmarks.presentation

sealed class BookmarksAction {
    data class NavigateToBook(val id: String) : BookmarksAction()
}
