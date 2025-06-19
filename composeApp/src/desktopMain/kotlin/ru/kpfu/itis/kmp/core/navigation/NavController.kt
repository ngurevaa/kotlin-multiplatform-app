package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

actual class NavController(
    internal val startDestination: Route,
    internal var backStackScreens: MutableSet<Route> = mutableSetOf()
) {
    private val currentRoute: MutableState<Route> = mutableStateOf(startDestination)

    @Composable
    actual fun getCurrentRoute(): State<Route> = currentRoute

    actual fun navigate(route: Route, navOptions: NavOptions) {
        if (route != currentRoute.value) {
            if (backStackScreens.contains(currentRoute.value) && currentRoute.value != startDestination) {
                backStackScreens.remove(currentRoute.value)
            }

            if (route == startDestination) {
                backStackScreens = mutableSetOf()
            } else {
                backStackScreens.add(currentRoute.value)
            }
            currentRoute.value = route
        }
    }

    actual fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            currentRoute.value = backStackScreens.last()
            backStackScreens.remove(currentRoute.value)
        }
    }
}
