package ru.kpfu.itis.kmp.feature.bookmarks.presentation

import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book

data class BookmarksViewState(
    val books: List<Book> = listOf()
)
