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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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
                modifier = Modifier.widthIn(max = 600.dp)
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
            text = "Hello!",
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "What do you want to read today?",
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Genres(
    pagerState: PagerState,
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
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(title, color = if (pagerState.currentPage == index) Color.Unspecified else MaterialTheme.colorScheme.secondary) }
            )
        }
    }
}
