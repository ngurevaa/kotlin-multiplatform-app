package ru.kpfu.itis.kmp.feature.presentation

sealed class BookAction {
    data object ShowError : BookAction()
}
