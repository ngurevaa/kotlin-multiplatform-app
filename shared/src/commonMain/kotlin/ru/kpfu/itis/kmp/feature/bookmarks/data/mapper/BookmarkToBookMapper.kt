package ru.kpfu.itis.kmp.feature.bookmarks.data.mapper

import ru.kpfu.itis.kmp.Bookmark
import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book

fun Bookmark.mapToBook(): Book {
    return Book(
        id = book_id,
        name = name,
        author = author,
        image = image
    )
}

fun List<Bookmark>.mapToBookList(): List<Book> {
    return map { it.mapToBook() }
}
