package ru.kpfu.itis.kmp.feature.search.presentation

sealed class SearchAction {
    data object ShowInternetConnectionError : SearchAction()
    data object ShowEmptySearchError : SearchAction()
    data class NavigateToBook(val id: String) : SearchAction()
}
