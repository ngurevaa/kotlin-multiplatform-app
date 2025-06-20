package ru.kpfu.itis.kmp.core.ui

import androidx.compose.runtime.staticCompositionLocalOf
import coil3.ImageLoader

val LocalImageLoader = staticCompositionLocalOf<ImageLoader> {
    error("ImageLoader not provided!")
}
