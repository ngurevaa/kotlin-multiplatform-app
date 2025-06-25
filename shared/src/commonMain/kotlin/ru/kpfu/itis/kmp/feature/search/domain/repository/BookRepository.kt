package ru.kpfu.itis.kmp.feature.search.domain.repository

import ru.kpfu.itis.kmp.feature.search.domain.model.Book

interface BookRepository {
    suspend fun searchBooksByTitle(query: String): List<Book>
    suspend fun searchBooksByAuthor(query: String): List<Book>
    suspend fun searchBooksByGenre(query: String): List<Book>
}
