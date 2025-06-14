package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

actual class NavController(
    internal val startDestination: Route,
    internal var backStackScreens: MutableSet<Route> = mutableSetOf()
) {
    var currentScreen: MutableState<Route> = mutableStateOf(startDestination)

    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            currentScreen.value = backStackScreens.last()
            backStackScreens.remove(currentScreen.value)
        }
    }
}

actual fun NavController.navigate(route: Route) {
    if (route != currentScreen.value) {
        if (backStackScreens.contains(currentScreen.value) && currentScreen.value != startDestination) {
            backStackScreens.remove(currentScreen.value)
        }

        if (route == startDestination) {
            backStackScreens = mutableSetOf()
        } else {
            backStackScreens.add(currentScreen.value)
        }

        currentScreen.value = route
    }

}
