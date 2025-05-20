package ru.kpfu.itis.kmp.core.designsystem

import androidx.compose.ui.graphics.Color

actual class CommonColor(
    actual val hex: Long
) {
    fun getColor(): Color {
        return Color(hex)
    }
}

actual object Colors {
    actual val primary = CommonColor(ru.kpfu.itis.kmp.core.designsystem.primary)
    actual val secondary = CommonColor(ru.kpfu.itis.kmp.core.designsystem.primary)
}

fun get() {
    Colors.primary.getColor()
}
