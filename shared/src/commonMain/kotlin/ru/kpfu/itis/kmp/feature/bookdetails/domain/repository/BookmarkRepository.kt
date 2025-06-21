package ru.kpfu.itis.kmp.feature.bookdetails.domain.repository

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

interface BookmarkRepository {
    suspend fun isBookmark(bookId: String): Boolean
    suspend fun saveBookmark(book: Book)
    suspend fun deleteBookmark(bookId: String)
}
