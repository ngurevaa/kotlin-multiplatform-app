package ru.kpfu.itis.kmp.feature.home.presentation

sealed class HomeAction {
    data object ShowInternetConnectionError : HomeAction()
    data class NavigateToBook(val id: String) : HomeAction()
    data object NavigateToLogin : HomeAction()
}
