package ru.kpfu.itis.kmp.core.designsystem

import platform.UIKit.UIColor

actual class CommonColor(
    actual val hex: Long
) {
    fun getColor(): UIColor {
        return UIColor()
    }
}

actual object Colors {
    actual val primary = CommonColor(ru.kpfu.itis.kmp.core.designsystem.primary)
    actual val secondary = CommonColor(ru.kpfu.itis.kmp.core.designsystem.primary)
}
