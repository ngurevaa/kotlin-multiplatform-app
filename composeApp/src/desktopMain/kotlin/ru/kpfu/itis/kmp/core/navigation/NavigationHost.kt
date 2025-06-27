package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
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
    NavHost(navController) {
        composable<Route.Registration> {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(Route.Login) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }

        composable<Route.Login> {
            LoginScreen(
                navigateToRegistration = { navController.navigate(Route.Registration) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }

        composable<Route.Home> {
            HomeScreen(
                navigateToBook = { id ->
                    navController.navigate(Route.BookDetails(id))
                },
                navigateToLogin = { navController.navigate(Route.Login) }
            )
        }

        composable<Route.Bookmarks> {
            BookmarksScreen(
                navigateToBook = { id ->
                    navController.navigate(Route.BookDetails(id))
                }
            )
        }

        composable<Route.Search> {
            SearchScreen(
                navigateToBook = { id ->
                    navController.navigate(Route.BookDetails(id))
                }
            )
        }

        composable<Route.BookDetails> {
            val id = (navController.getCurrentRoute().value as Route.BookDetails).id
            BookDetailsScreen(
                id = id,
                navigateBack = { navController.navigateBack() }
            )
        }

    }.build()
}

class NavHost(
    val navController: NavController,
    val contents: @Composable NavigationGraphBuilder.() -> Unit
) {

    @Composable
    fun build() {
        NavigationGraphBuilder().renderContents()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavHost.navController
    ) {
        @Composable
        fun renderContents() {
            this@NavHost.contents(this)
        }
    }
}

@Composable
inline fun <reified T : Route> NavHost.NavigationGraphBuilder.composable(
    noinline content: @Composable (T) -> Unit
) {
    if (navController.getCurrentRoute().value is T) {
        content(navController.getCurrentRoute().value as T)
    }
}
