package ru.kpfu.itis.kmp.feature.search.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.kpfu.itis.kmp.feature.search.data.datasource.remote.BookResponse

class RemoteBookDatasource(
    private val httpClient: HttpClient
) {
    suspend fun searchByTitle(query: String): BookResponse {
        return httpClient.get {
            parameter(PARAM_Q, "intitle:$query")
            parameter(PARAM_ORDER_BY, "relevance")
            parameter(PARAM_MAX_RESULTS, "16")
            parameter(PARAM_KEY, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
        }.body<BookResponse>()
    }

    suspend fun searchByAuthor(query: String): BookResponse {
        return httpClient.get {
            parameter(PARAM_Q, "inauthor:$query")
            parameter(PARAM_ORDER_BY, "relevance")
            parameter(PARAM_MAX_RESULTS, "16")
            parameter(PARAM_KEY, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
        }.body<BookResponse>()
    }

    suspend fun searchByGenre(query: String): BookResponse {
        return httpClient.get {
            parameter(PARAM_Q, "subject:$query")
            parameter(PARAM_ORDER_BY, "relevance")
            parameter(PARAM_MAX_RESULTS, "16")
            parameter(PARAM_KEY, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
        }.body<BookResponse>()
    }

    companion object {
        private const val PARAM_Q = "q"
        private const val PARAM_ORDER_BY = "orderBy"
        private const val PARAM_MAX_RESULTS = "maxResults"
        private const val PARAM_KEY = "key"
    }
}
