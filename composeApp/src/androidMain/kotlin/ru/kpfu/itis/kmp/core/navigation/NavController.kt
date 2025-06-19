package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.flow.SharingStarted
import androidx.compose.runtime.getValue
import kotlin.toString

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
}
