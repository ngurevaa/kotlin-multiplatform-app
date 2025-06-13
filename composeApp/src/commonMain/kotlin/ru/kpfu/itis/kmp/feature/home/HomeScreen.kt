package ru.kpfu.itis.kmp.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel

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
                modifier = Modifier.padding(start = 24.dp).widthIn(max = 600.dp)
            )
            HorizontalPager(
                state = pagerState
            ) { page ->
                Text("Content for $page")
            }
        }
    }
}

@Composable
fun HelloHeader(modifier: Modifier = Modifier) {
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
fun Genres(
    pagerState: PagerState,
    genres: List<Genre> = listOf(),
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Fiction", "Science", "Psychology", "Romance", "Horror", "Fantasy", "History")
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
                text = { Text(genre.name, color = if (pagerState.currentPage == index) Color.Unspecified else MaterialTheme.colorScheme.secondary) }
            )
        }
    }
}
