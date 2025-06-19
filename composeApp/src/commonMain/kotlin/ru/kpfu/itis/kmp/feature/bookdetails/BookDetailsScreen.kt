package ru.kpfu.itis.kmp.feature.bookdetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun BookDetailsScreen(
    id: String
) {
    Text(text = "bookId $id")
}
