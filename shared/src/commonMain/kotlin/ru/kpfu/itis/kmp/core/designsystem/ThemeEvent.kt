package ru.kpfu.itis.kmp.core.designsystem

sealed class ThemeEvent {
    data class ChangeTheme(val isDarkTheme: Boolean) : ThemeEvent()
}
