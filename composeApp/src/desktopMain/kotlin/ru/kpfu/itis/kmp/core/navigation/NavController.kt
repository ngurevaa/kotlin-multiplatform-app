package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class NavController(
    private val startDestination: Route,
    private var backStackScreens: MutableSet<Route> = mutableSetOf()
) {
    var currentScreen: MutableState<Route> = mutableStateOf(startDestination)

    fun navigate(route: Route) {
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

    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            currentScreen.value = backStackScreens.last()
            backStackScreens.remove(currentScreen.value)
        }
    }
}
