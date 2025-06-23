package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ru.kpfu.itis.kmp.feature.auth.LoginScreen
import ru.kpfu.itis.kmp.feature.auth.RegistrationScreen
import ru.kpfu.itis.kmp.feature.bookdetails.BookDetailsScreen
import ru.kpfu.itis.kmp.feature.bookmarks.BookmarksScreen
import ru.kpfu.itis.kmp.feature.home.HomeScreen
import ru.kpfu.itis.kmp.feature.search.SearchScreen

@Composable
actual fun NavigationHost(
    startDestination: Route,
    navController: NavController
) {
    NavHost(
        startDestination = startDestination,
        navController = navController.navHostController
    ) {
        composable<Route.Registration> {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(Route.Login, NavOptions(popUpToIndex = 0)) },
                navigateToHome = { navController.navigate(Route.Home, NavOptions(popUpToIndex = 0)) }
            )
        }

        composable<Route.Login> {
            LoginScreen(
                navigateToRegistration = {
                    navController.navigate(Route.Registration, NavOptions(popUpToIndex = 0))
                },
                navigateToHome = {
                    navController.navigate(Route.Home, NavOptions(popUpToIndex = 0))
                }
            )
        }

        composable<Route.Home> {
            HomeScreen(
                navigateToBook = { id ->
                    navController.navigate(Route.BookDetails(id), NavOptions().copy(launchSingleTop = true))
                }
            )
        }

        composable<Route.Bookmarks> {
            BookmarksScreen(
                navigateToBook = { id ->
                    navController.navigate(Route.BookDetails(id), NavOptions().copy(launchSingleTop = true))
                }
            )
        }

        composable<Route.Search> {
            SearchScreen()
        }

        composable<Route.BookDetails> { backStackEntry ->
            val id = backStackEntry.toRoute<Route.BookDetails>().id
            BookDetailsScreen(
                id = id,
                navigateBack = { navController.navigateBack() }
            )
        }
    }
}
