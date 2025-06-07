package ru.kpfu.itis.kmp.core.navigation

sealed interface Route {
    data object Registration : Route
    data object Login : Route
}
