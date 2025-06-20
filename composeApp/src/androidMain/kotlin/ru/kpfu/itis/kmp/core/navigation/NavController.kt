package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

actual class NavController(
    internal val navHostController: NavHostController
) {
    @Composable
    actual fun getCurrentRoute(): State<Route> {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        return remember(navBackStackEntry) {
            derivedStateOf {
                navBackStackEntry?.destination?.route
                    ?.let { fromStringToRoute(it.toString()) }
                    ?: Route.Home
            }
        }
    }

    actual fun navigate(route: Route, navOptions: NavOptions) {
        navHostController.navigate(route) {
            navOptions.popUpToIndex?.let { id -> popUpTo(id) }
            launchSingleTop = navOptions.launchSingleTop
        }
    }

    actual fun navigateBack() {
        navHostController.popBackStack()
    }
}
