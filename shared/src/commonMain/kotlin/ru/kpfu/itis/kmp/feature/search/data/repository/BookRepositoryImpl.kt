package ru.kpfu.itis.kmp.feature.search.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.search.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.search.data.datasource.remote.BookResponse
import ru.kpfu.itis.kmp.feature.search.data.mapper.mapToBookList
import ru.kpfu.itis.kmp.feature.search.domain.model.Book
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository

class BookRepositoryImpl(
    private val remoteBookDatasource: RemoteBookDatasource
) : BookRepository {

    override suspend fun searchBooksByTitle(query: String): List<Book> {
        return withContext(Dispatchers.IO) {
            remoteBookDatasource.searchByTitle(query).mapToBookList()
        }
    }

    override suspend fun searchBooksByAuthor(query: String): List<Book> {
        return withContext(Dispatchers.IO) {
            remoteBookDatasource.searchByAuthor(query).mapToBookList()
        }
    }

    override suspend fun searchBooksByGenre(query: String): List<Book> {
        return withContext(Dispatchers.IO) {
            remoteBookDatasource.searchByGenre(query).mapToBookList()
        }
    }
}
