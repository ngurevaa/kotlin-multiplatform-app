package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import io.ktor.http.path
import ru.kpfu.itis.kmp.core.network.BASE_PATH
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote.BookDetailsResponse
import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book

internal class RemoteBookDetailsDatasource(
    private val httpClient: HttpClient
) {
    suspend fun getBookDetails(id: String): Book {
        val response = httpClient.get {
            url {
                path(id)
            }
        }.body<BookDetailsResponse>()

        return Book(
            name = response.volumeInfo?.title ?: "",
            author = response.volumeInfo?.authors?.joinToString(", ") ?: "",
            image = response.volumeInfo?.imageLinks?.thumbnail ?: "",
            overview = response.volumeInfo?.description?.replace(Regex("<[^>]*>"), "") ?: ""
        )
    }
}
