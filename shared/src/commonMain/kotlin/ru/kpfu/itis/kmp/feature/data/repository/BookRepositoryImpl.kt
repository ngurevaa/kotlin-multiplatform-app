package ru.kpfu.itis.kmp.feature.data.repository

import ru.kpfu.itis.kmp.feature.data.datasource.PersistentDataSource
import ru.kpfu.itis.kmp.feature.domain.model.Book
import ru.kpfu.itis.kmp.feature.domain.repository.BookRepository

class BookRepositoryImpl(
    private val persistentDataSource: PersistentDataSource
) : BookRepository {
    override suspend fun saveBook(book: Book) {
        persistentDataSource.insert(book.name)
    }
}
