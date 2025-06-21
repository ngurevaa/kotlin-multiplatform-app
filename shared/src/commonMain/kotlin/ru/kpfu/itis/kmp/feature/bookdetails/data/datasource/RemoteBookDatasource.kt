package ru.kpfu.itis.kmp.feature.bookdetails.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import ru.kpfu.itis.kmp.feature.bookdetails.data.datasource.remote.BookDetailsResponse

internal class RemoteBookDatasource(
    private val httpClient: HttpClient
) {
    suspend fun getBookDetails(id: String): BookDetailsResponse {
        return httpClient.get {
            url {
                path(id)
            }
        }.body<BookDetailsResponse>()
    }
}
