package ru.kpfu.itis.kmp.feature.bookdetails

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.cat_read_book
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.kpfu.itis.kmp.core.designsystem.component.TopBar
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsEvent
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsViewModel

@Composable
fun BookDetailsScreen(
    id: String,
    viewModel: BookDetailsViewModel = koinViewModel<BookDetailsViewModel>(),
    navigateBack: () -> Unit
) {
    val obtainEvent = viewModel::obtainEvent

    LaunchedEffect(key1 = id) {
        obtainEvent(BookDetailsEvent.LoadBook(id))
    }

    Scaffold(
        topBar = { TopBar(
            navigateBack = {
                navigateBack()
                obtainEvent(BookDetailsEvent.ClearBook)
            }
        ) }
    ) {
        BookDetailsScreenContent(viewModel)
    }
}

@Composable
internal fun BookDetailsScreenContent(
    viewModel: BookDetailsViewModel
) {
    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
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
fun BookName(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
        modifier = modifier
    )
}

@Composable
fun BookAuthor(
    author: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = author,
        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
        color = MaterialTheme.colorScheme.secondary,
        modifier = modifier
    )
}

@Composable
fun BookOverview(
    overview: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Overview",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = overview,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
