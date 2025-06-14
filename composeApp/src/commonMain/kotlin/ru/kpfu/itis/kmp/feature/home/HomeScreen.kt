package ru.kpfu.itis.kmp.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.hello
import exampleapp.composeapp.generated.resources.what_do_you_want_to_read_today
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BookCard
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel
import androidx.compose.foundation.lazy.items
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>()
) {
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
            HelloHeader(modifier = Modifier.widthIn(max = 600.dp).padding(24.dp))
            Genres(
                pagerState = pagerState,
                genres = state.genres,
                modifier = Modifier.widthIn(max = 600.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            BooksByGenre(
                pagerState = pagerState,
                state = state,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
internal fun BooksByGenre(
    pagerState: PagerState,
    state: HomeViewState,
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
                items(books) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        BookCard(it)
                    }
                }
            }
        }
    }
}

@Composable
internal fun HelloHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
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
