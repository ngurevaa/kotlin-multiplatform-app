package ru.kpfu.itis.kmp.feature.bookdetails.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.RemoteBookDatasource
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookRepository

internal class BookRepositoryImpl(
    private val remoteBookDetailsDatasource: RemoteBookDatasource
) : BookRepository {

    override suspend fun getBookDetails(id: String): Book {
        return withContext(Dispatchers.IO) {
            val response = remoteBookDetailsDatasource.getBookDetails(id)

            Book(
                id = id,
                name = response.volumeInfo?.title ?: "",
                author = response.volumeInfo?.authors?.joinToString(", ") ?: "",
                image = response.volumeInfo?.imageLinks?.thumbnail ?: "",
                overview = response.volumeInfo?.description?.replace(Regex("<[^>]*>"), "") ?: ""
            )
        }
    }
}
