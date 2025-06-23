package ru.kpfu.itis.kmp.core.designsystem

import androidx.compose.runtime.staticCompositionLocalOf

val LocalThemeViewModel = staticCompositionLocalOf<ThemeViewModel> { error("No ViewModel!") }
