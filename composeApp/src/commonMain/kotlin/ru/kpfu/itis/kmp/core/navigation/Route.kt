package ru.kpfu.itis.kmp.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Registration : Route
    @Serializable
    data object Login : Route
}
