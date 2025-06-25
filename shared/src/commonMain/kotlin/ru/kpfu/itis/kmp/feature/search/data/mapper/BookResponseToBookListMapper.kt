package ru.kpfu.itis.kmp.feature.search.data.mapper

import ru.kpfu.itis.kmp.feature.search.data.datasource.remote.BookResponse
import ru.kpfu.itis.kmp.feature.search.domain.model.Book

fun BookResponse.mapToBookList(): List<Book> {
    return items?.map {
        Book(
            id = it.id ?: "",
            name = it.volumeInfo?.title ?: "",
            author = it.volumeInfo?.authors?.joinToString(", ") ?: "",
            image = it.volumeInfo?.imageLinks?.thumbnail ?: ""
        )
    } ?: listOf<Book>()
}
