package ru.kpfu.itis.kmp.core.designsystem.component

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Bookmark
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.BookmarkFill
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Home
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.HomeFill
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.Search
import ru.kpfu.itis.kmp.core.navigation.NavController
import ru.kpfu.itis.kmp.core.navigation.NavOptions
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.ui.ClearRippleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavController) {
    val routes = listOf(Route.Home, Route.Search, Route.Bookmarks)

    val selectedIcons = listOf(IconPack.HomeFill, IconPack.Search, IconPack.BookmarkFill)
    val unselectedIcons = listOf(IconPack.Home, IconPack.Search, IconPack.Bookmark)

    val currentRoute by navController.getCurrentRoute()
    var selectedItem = remember(currentRoute) {
        routes.indexOfFirst { route ->
            currentRoute == route
        }.takeIf { it >= 0 } ?: 0
    }

    NavigationBar(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(16.dp)
            .shadow(
                shape = RoundedCornerShape(64.dp),
                elevation = 32.dp
            )
    ) {
        routes.forEachIndexed { index, route ->
            ClearRippleTheme {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = if (selectedItem == index) selectedIcons[index]
                                else unselectedIcons[index],
                            contentDescription = null,
                            tint = if (selectedItem == index) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.secondary
                        )
                    },
                    selected = false,
                    onClick = {
                        selectedItem = index
                        navController.navigate(route, NavOptions(popUpToIndex = 0))
                    },
                )
            }
        }
    }
}
