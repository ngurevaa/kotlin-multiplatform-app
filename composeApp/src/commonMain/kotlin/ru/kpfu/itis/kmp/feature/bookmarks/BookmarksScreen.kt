package ru.kpfu.itis.kmp.feature.bookmarks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.bookmarks
import exampleapp.composeapp.generated.resources.data_loading_error
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BookCard
import ru.kpfu.itis.kmp.core.designsystem.component.TopSnackbar
import ru.kpfu.itis.kmp.core.ui.noRippleClickable
import ru.kpfu.itis.kmp.core.ui.showSnackbar
import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookmarks.presentation.BookmarksAction
import ru.kpfu.itis.kmp.feature.bookmarks.presentation.BookmarksEvent
import ru.kpfu.itis.kmp.feature.bookmarks.presentation.BookmarksViewModel

@Composable
fun BookmarksScreen(
    viewModel: BookmarksViewModel = koinViewModel<BookmarksViewModel>(),
    navigateToBook: (String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box {
        TopSnackbar(snackbarHostState)
        BookmarksScreenContent(viewModel = viewModel)
    }

    val dataLoadingError = stringResource(Res.string.data_loading_error)
    LaunchedEffect(Unit) {
        viewModel.obtainEvent(BookmarksEvent.OpenScreen)
        viewModel.obtainEvent(BookmarksEvent.LoadBooks)

        viewModel.getActions().collectLatest { action ->
            when(action) {
                is BookmarksAction.NavigateToBook -> navigateToBook(action.id)
                is BookmarksAction.ShowBookmarksLoadingError -> {
                    showSnackbar(snackbarHostState, coroutineScope, dataLoadingError)
                }
            }
        }
    }
}

@Composable
internal fun BookmarksScreenContent(
    viewModel: BookmarksViewModel
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookmarksHeader(modifier = Modifier.widthIn(max = 600.dp).padding(24.dp))
        Bookmarks(
            books = state.books,
            clickToBook = { obtainEvent(BookmarksEvent.ClickToBook(it)) }
        )
    }
}

@Composable
internal fun BookmarksHeader(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.bookmarks),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
internal fun Bookmarks(
    books: List<Book>,
    clickToBook: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 116.dp)
    ) {

        items(books) { book ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                BookCard(
                    name = book.name,
                    author = book.author,
                    image = book.image,
                    modifier = Modifier.noRippleClickable {
                        clickToBook(book.id)
                    }
                )
            }
        }
    }
}
