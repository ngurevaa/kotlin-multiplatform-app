package ru.kpfu.itis.kmp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.hello
import exampleapp.composeapp.generated.resources.internet_connection_error
import exampleapp.composeapp.generated.resources.what_do_you_want_to_read_today
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BookCard
import ru.kpfu.itis.kmp.core.designsystem.component.TopSnackbar
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.DarkMode
import ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack.LightMode
import ru.kpfu.itis.kmp.core.ui.noRippleClickable
import ru.kpfu.itis.kmp.core.ui.showSnackbar
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.presentation.HomeAction
import ru.kpfu.itis.kmp.feature.home.presentation.HomeEvent
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
    navigateToBook: (String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box {
        TopSnackbar(snackbarHostState)
        HomeScreenContent(viewModel = viewModel)
    }

    val internetConnectionError = stringResource(Res.string.internet_connection_error)
    LaunchedEffect(Unit) {
        viewModel.getActions().collectLatest { action ->
            when (action) {
                is HomeAction.ShowInternetConnectionError -> {
                    showSnackbar(snackbarHostState, coroutineScope, internetConnectionError)
                }
                is HomeAction.NavigateToBook -> {
                    navigateToBook(action.id)
                }
            }
        }
    }
}

@Composable
internal fun HomeScreenContent(viewModel: HomeViewModel) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = {7})

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HelloHeader(
                modifier = Modifier.widthIn(max = 600.dp).padding(24.dp),
                isDarkTheme = state.isDarkTheme,
                changeAppTheme = { obtainEvent(HomeEvent.ChangeAppTheme(it)) }
            )
            Genres(
                pagerState = pagerState,
                genres = state.genres,
                modifier = Modifier.widthIn(max = 600.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (state.isLoading) {
                CircularProgressIndicator()
            }
            else {
                BooksByGenre(
                    pagerState = pagerState,
                    state = state,
                    clickToBook = { obtainEvent(HomeEvent.ClickToBook(it)) },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
internal fun BooksByGenre(
    pagerState: PagerState,
    state: HomeViewState,
    clickToBook: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        Column {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 116.dp)
            ) {
                val genre = state.genres[page]
                val books = state.books[genre] ?: listOf()
                items(books) { book ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        BookCard(
                            book = book,
                            modifier = Modifier.noRippleClickable {
                                clickToBook(book.id)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun HelloHeader(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    changeAppTheme: (Boolean) -> Unit
) {
    Row(modifier = modifier) {
        Column {
            Text(
                text = stringResource(Res.string.hello),
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(Res.string.what_do_you_want_to_read_today),
                style = MaterialTheme.typography.headlineMedium,
            )
        }
        Icon(
            imageVector = if (isDarkTheme) IconPack.LightMode else IconPack.DarkMode,
            contentDescription = null,
            modifier = Modifier.noRippleClickable {
                changeAppTheme(!isDarkTheme)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Genres(
    pagerState: PagerState,
    genres: List<Genre> = listOf(),
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    SecondaryScrollableTabRow (
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        divider = {},
        modifier = modifier
    ) {
        genres.forEachIndexed { index, genre ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Text(
                        text = genre.name,
                        color = if (pagerState.currentPage == index) Color.Unspecified
                            else MaterialTheme.colorScheme.secondary
                    )
                }
            )
        }
    }
}
