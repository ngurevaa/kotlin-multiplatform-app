package ru.kpfu.itis.kmp.feature.bookdetails.data.mapper

import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote.BookDetailsResponse
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

fun BookDetailsResponse.mapToBook(): Book {
    return Book(
        id = id ?: "",
        name = volumeInfo?.title ?: "",
        author = volumeInfo?.authors?.joinToString(", ") ?: "",
        image = volumeInfo?.imageLinks?.thumbnail ?: "",
        overview = volumeInfo?.description?.replace(Regex("<[^>]*>"), "") ?: ""
    )
}
