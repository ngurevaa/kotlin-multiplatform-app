package ru.kpfu.itis.kmp.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.cat_read_book
import org.jetbrains.compose.resources.painterResource
import ru.kpfu.itis.kmp.core.ui.LocalImageLoader

@Composable
fun BookCard(
    name: String,
    author: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(150.dp)
    ) {
        BookImage(image)
        Spacer(modifier = Modifier.height(12.dp))
        BookName(name)
        BookAuthor(author)
    }
}

@Composable
internal fun BookImage(image: String) {
    Card(
        shape = RoundedCornerShape(20.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            contentScale = ContentScale.FillBounds,
            imageLoader = LocalImageLoader.current,
            placeholder = painterResource(Res.drawable.cat_read_book)
        )
    }
}

@Composable
internal fun BookName(name:String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
    )
}

@Composable
internal fun BookAuthor(author: String) {
    Text(
        text = author,
        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
        color = MaterialTheme.colorScheme.secondary
    )
}
