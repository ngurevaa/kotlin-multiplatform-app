package ru.kpfu.itis.kmp.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.feature.presentation.BookEvent
import ru.kpfu.itis.kmp.feature.presentation.BookViewModel

@Composable
fun BookScreen(
    viewModel: BookViewModel = koinViewModel<BookViewModel>()
) {
    val state by viewModel.viewStates.collectAsState()

    Column {
        Text(
            text = "title: ${state.title}",
            style = MaterialTheme.typography.titleMedium
        )
        Button(
            onClick = { viewModel.obtainEvent(BookEvent.CreateBook("title book")) }
        ) {
            Text(
                text = "click",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
