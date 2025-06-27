package ru.kpfu.itis.kmp.feature.bookdetails.presentation

sealed class BookDetailsEvent {
    data class LoadBook(val id: String) : BookDetailsEvent()
    data object ClearBook : BookDetailsEvent()
    data object SaveBookmark : BookDetailsEvent()
    data object DeleteBookmark : BookDetailsEvent()
    data object OpenScreen : BookDetailsEvent()
}
