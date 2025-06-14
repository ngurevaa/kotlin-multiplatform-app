package ru.kpfu.itis.kmp.core.navigation

import androidx.navigation.NavHostController

actual class NavController(
    internal val navHostController: NavHostController
) {

}

actual fun NavController.navigate(route: Route) {
    navHostController.navigate(route)
}
