package ru.kpfu.itis.kmp.feature.domain.repository

import ru.kpfu.itis.kmp.feature.domain.model.Book

interface BookRepository {
    suspend fun saveBook(book: Book)
}
