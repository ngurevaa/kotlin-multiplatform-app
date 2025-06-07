package ru.kpfu.itis.kmp

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.navigation.NavigationHost

@Composable
@Preview
fun App() {
    AppTheme {
        NavigationHost()
    }
}
