package ru.kpfu.itis.kmp.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Registration : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object Home : Route

    @Serializable
    data class BookDetails(val id: String) : Route
}

fun fromStringToRoute(route: String): Route {
    return when {
        route.endsWith(".Login") -> Route.Login
        route.endsWith(".Registration") -> Route.Registration
        route.endsWith(".Home") -> Route.Home
        route.endsWith(".BookDetails/{id}") -> Route.BookDetails("")
        else -> Route.Home
    }
}
