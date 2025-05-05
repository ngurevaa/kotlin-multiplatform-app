package ru.kpfu.itis.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.compose.KoinContext
import org.koin.compose.getKoin
import org.koin.core.context.KoinContext
import ru.kpfu.itis.kmp.feature.BookScreen

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "ExampleApp",
    ) {
//        App()
        BookScreen()
    }
}
