package ru.kpfu.itis.kmp.core.ui

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.RippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClearRippleTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalRippleConfiguration provides RippleConfiguration(
            color = Color.Unspecified,
            rippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
        ),
        content = content
    )
}
