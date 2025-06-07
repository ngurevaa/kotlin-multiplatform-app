package ru.kpfu.itis.kmp

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.navigation.rememberNavController

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "BookApp",
    ) {
        App()
    }
}
