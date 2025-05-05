package ru.kpfu.itis.kmp.feature.presentation

sealed class BookEvent {
    data class CreateBook(val name: String) : BookEvent()
}
