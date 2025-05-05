package ru.kpfu.itis.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform