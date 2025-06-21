package ru.kpfu.itis.kmp.feature.home.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.kpfu.itis.kmp.feature.home.data.datasource.remote.BookApiResponse
import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

internal class RemoteHomeDatasource(
    private val httpClient: HttpClient
) {
    suspend fun getBooksByGenre(genre: Genre): List<Book> {
        val response = httpClient.get {
            parameter(PARAM_Q, "subject:${genre.name}")
            parameter(PARAM_ORDER_BY, "relevance")
            parameter(PARAM_MAX_RESULTS, "16")
            parameter(PARAM_KEY, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
        }.body<BookApiResponse>()

        val books = mutableListOf<Book>()
        for (book in response.items) {
            books += Book(
                id = book.id ?: "",
                name = book.volumeInfo?.title ?: "",
                author = book.volumeInfo?.authors?.joinToString(", ") ?: "",
                image = book.volumeInfo?.imageLinks?.thumbnail ?: ""
            )
        }
        return books
    }

    companion object {
        private const val PARAM_Q = "q"
        private const val PARAM_ORDER_BY = "orderBy"
        private const val PARAM_MAX_RESULTS = "maxResults"
        private const val PARAM_KEY = "key"
    }
}
