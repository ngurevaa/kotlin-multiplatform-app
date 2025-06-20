package ru.kpfu.itis.kmp.feature.bookdetails.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDetailsDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookDetailsRepository

internal class BookDetailsRepositoryImpl(
    private val remoteBookDetailsDatasource: RemoteBookDetailsDatasource
) : BookDetailsRepository {

    override suspend fun getBookDetails(id: String): Book {
        return withContext(Dispatchers.IO) {
            remoteBookDetailsDatasource.getBookDetails(id)
        }
    }
}
