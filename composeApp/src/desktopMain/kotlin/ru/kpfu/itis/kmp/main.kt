package ru.kpfu.itis.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.feature.auth.LoginScreen

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "ExampleApp",
    ) {
        AppTheme { LoginScreen() }
    }
}
