package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
actual fun rememberNavController(
    startDestination: Route
): NavController = rememberSaveable {
    val backStackScreens: MutableSet<Route> = mutableSetOf()
    NavController(startDestination, backStackScreens)
}
