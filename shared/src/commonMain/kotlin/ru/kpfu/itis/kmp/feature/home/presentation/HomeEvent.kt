package ru.kpfu.itis.kmp.feature.home.presentation

sealed class HomeEvent {
    data class ClickToBook(val id: String) : HomeEvent()
    data class ChangeAppTheme(val isDarkMode: Boolean) : HomeEvent()
}
