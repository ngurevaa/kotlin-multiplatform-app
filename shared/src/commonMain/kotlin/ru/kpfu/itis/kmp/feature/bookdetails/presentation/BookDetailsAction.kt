package ru.kpfu.itis.kmp.feature.bookdetails.presentation

sealed class BookDetailsAction {
    data object ShowInternetConnectionError : BookDetailsAction()
}
