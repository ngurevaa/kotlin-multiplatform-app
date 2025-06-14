package ru.kpfu.itis.kmp.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.kpfu.itis.kmp.feature.home.domain.model.Book

@Composable
fun BookCard(book: Book) {
    Column(
        modifier = Modifier.width(150.dp)
    ) {
        Card {
            AsyncImage(
                model = book.image,
                contentDescription = null,
                modifier = Modifier.size(width = 150.dp, height = 200.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = book.name,
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
        )
        Text(
            text = book.author,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
