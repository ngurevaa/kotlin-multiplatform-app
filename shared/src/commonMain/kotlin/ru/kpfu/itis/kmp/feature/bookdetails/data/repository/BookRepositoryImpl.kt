package ru.kpfu.itis.kmp.feature.bookdetails.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.data.mapper.mapToBook
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookRepository

internal class BookRepositoryImpl(
    private val remoteBookDetailsDatasource: RemoteBookDatasource
) : BookRepository {

    override suspend fun getBookDetails(id: String): Book {
        return withContext(Dispatchers.IO) {
            remoteBookDetailsDatasource.getBookDetails(id).mapToBook()
        }
    }
}
