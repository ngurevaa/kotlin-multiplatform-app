package ru.kpfu.itis.kmp.feature.home.domain.repository

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

interface BookRepository {
    suspend fun getBooksByGenre(genre: Genre): List<Book>
}
