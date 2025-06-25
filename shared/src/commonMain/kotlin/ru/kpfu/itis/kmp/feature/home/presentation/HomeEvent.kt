package ru.kpfu.itis.kmp.feature.home.presentation

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

sealed class HomeEvent {
    data class ClickToBook(val id: String) : HomeEvent()
    data class UpdateCurrentGenre(val genre: Genre) : HomeEvent()
}
