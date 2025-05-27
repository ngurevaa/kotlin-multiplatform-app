package ru.kpfu.itis.kmp

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.getKoin
import org.koin.compose.koinInject
import org.koin.core.context.KoinContext
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.feature.BookScreen
import ru.kpfu.itis.kmp.feature.auth.LoginScreen
import ru.kpfu.itis.kmp.feature.auth.RegistrationScreen
import ru.kpfu.itis.kmp.feature.data.datasource.RemoteDataSource

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "ExampleApp",
    ) {
        AppTheme { RegistrationScreen() }
    }
}
