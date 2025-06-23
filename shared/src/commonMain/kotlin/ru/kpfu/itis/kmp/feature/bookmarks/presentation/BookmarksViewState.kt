package ru.kpfu.itis.kmp.feature.bookmarks.presentation

import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book
import androidx.compose.runtime.Immutable

@Immutable
data class BookmarksViewState(
    val books: List<Book> = listOf()
)
