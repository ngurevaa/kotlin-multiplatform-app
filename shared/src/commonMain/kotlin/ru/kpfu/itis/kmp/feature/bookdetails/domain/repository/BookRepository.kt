package ru.kpfu.itis.kmp.feature.bookdetails.domain.repository

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

interface BookRepository {
    suspend fun getBookDetails(id: String): Book
}
