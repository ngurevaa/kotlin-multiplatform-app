package ru.kpfu.itis.kmp.feature.home.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.home.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.home.data.mapper.mapToBookList
import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.BookRepository

internal class BookRepositoryImpl(
    private val remoteBookDatasource: RemoteBookDatasource
) : BookRepository {
    override suspend fun getBooksByGenre(genre: Genre): List<Book> {
        return withContext(Dispatchers.IO) {
            remoteBookDatasource.getBooksByGenre(genre).mapToBookList()
        }
    }
}
