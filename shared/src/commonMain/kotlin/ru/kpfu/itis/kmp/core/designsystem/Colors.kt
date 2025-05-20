package ru.kpfu.itis.kmp.core.designsystem

val primary = 0xFF7A580C

expect class CommonColor {
    open val hex: Long
}

expect object Colors {
    val primary: CommonColor
    val secondary: CommonColor
}
