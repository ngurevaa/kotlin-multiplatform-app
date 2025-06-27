package ru.kpfu.itis.kmp.feature.bookdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.cat_read_book
import exampleapp.composeapp.generated.resources.data_saving_error
import exampleapp.composeapp.generated.resources.internet_connection_error
import exampleapp.composeapp.generated.resources.overview
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BookTopBar
import ru.kpfu.itis.kmp.core.ui.showSnackbar
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsAction
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsEvent
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsViewModel
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsViewState

@Composable
fun BookDetailsScreen(
    id: String,
    viewModel: BookDetailsViewModel = koinViewModel<BookDetailsViewModel>(),
    navigateBack: () -> Unit
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    LaunchedEffect(key1 = id) {
        obtainEvent(BookDetailsEvent.OpenScreen)
        obtainEvent(BookDetailsEvent.LoadBook(id))
    }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            BookTopBar(
                navigateBack = {
                    navigateBack()
                    obtainEvent(BookDetailsEvent.ClearBook)
                },
                isBookmarked = state.isBookmarked,
                saveBookmark = { obtainEvent(BookDetailsEvent.SaveBookmark) },
                deleteBookmark = { obtainEvent(BookDetailsEvent.DeleteBookmark) }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        BookDetailsScreenContent(state)
    }

    val internetConnectionError = stringResource(Res.string.internet_connection_error)
    val dataSavingError = stringResource(Res.string.data_saving_error)
    LaunchedEffect(Unit) {
        viewModel.getActions().collectLatest { action ->
            when(action) {
                BookDetailsAction.ShowInternetConnectionError -> {
                    showSnackbar(snackbarHostState, coroutineScope, internetConnectionError)
                }
                BookDetailsAction.ShowBookmarkSavingError -> {
                    showSnackbar(snackbarHostState, coroutineScope, dataSavingError)
                }
            }
        }
    }
}

@Composable
internal fun BookDetailsScreenContent(
    state: BookDetailsViewState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
        else {
            BookImage(state.image)
            Spacer(modifier = Modifier.height(16.dp))
            BookName(state.name)
            BookAuthor(state.author)
            Spacer(modifier = Modifier.height(16.dp))
            BookOverview(
                overview = state.overview,
                modifier = Modifier.fillMaxWidth().padding(24.dp)
            )
        }
    }
}

@Composable
internal fun BookImage(
    image: String
) {
    Card(
        shape = RoundedCornerShape(20.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.size(width = 250.dp, height = 300.dp),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(Res.drawable.cat_read_book)
        )
    }
}

@Composable
internal fun BookName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
        modifier = modifier,
        color = MaterialTheme.colorScheme.scrim,
        textAlign = TextAlign.Center
    )
}

@Composable
internal fun BookAuthor(
    author: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = author,
        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
internal fun BookOverview(
    overview: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.overview),
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
            color = MaterialTheme.colorScheme.scrim
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = overview,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
