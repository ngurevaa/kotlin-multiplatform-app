package ru.kpfu.itis.kmp.feature.bookmarks.data.mapper

import ru.kpfu.itis.kmp.BookmarkDB
import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book

fun BookmarkDB.mapToBook(): Book {
    return Book(
        id = book_id,
        name = name,
        author = author,
        image = image
    )
}

fun List<BookmarkDB>.mapToBookList(): List<Book> {
    return map { it.mapToBook() }
}
