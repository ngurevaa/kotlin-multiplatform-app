package ru.kpfu.itis.kmp.feature.search.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.kpfu.itis.kmp.core.network.Params
import ru.kpfu.itis.kmp.feature.search.data.datasource.remote.BookResponse

internal class RemoteBookDatasource(
    private val httpClient: HttpClient
) {
    suspend fun searchByTitle(query: String): BookResponse {
        return httpClient.get {
            parameter(Params.Q, "${Params.Q_IN_TITLE}$query")
            parameter(Params.ORDER_BY, "relevance")
            parameter(Params.MAX_RESULTS, "16")
        }.body<BookResponse>()
    }

    suspend fun searchByAuthor(query: String): BookResponse {
        return httpClient.get {
            parameter(Params.Q, "${Params.Q_IN_AUTHOR}$query")
            parameter(Params.ORDER_BY, "relevance")
            parameter(Params.MAX_RESULTS, "16")
        }.body<BookResponse>()
    }

    suspend fun searchByGenre(query: String): BookResponse {
        return httpClient.get {
            parameter(Params.Q, "${Params.Q_SUBJECT}$query")
            parameter(Params.ORDER_BY, "relevance")
            parameter(Params.MAX_RESULTS, "16")
        }.body<BookResponse>()
    }
}
