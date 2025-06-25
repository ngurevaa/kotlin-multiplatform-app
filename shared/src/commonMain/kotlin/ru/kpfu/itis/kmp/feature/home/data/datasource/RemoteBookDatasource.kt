package ru.kpfu.itis.kmp.feature.home.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.kpfu.itis.kmp.core.network.Params
import ru.kpfu.itis.kmp.feature.home.data.datasource.remote.BookResponse
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

internal class RemoteBookDatasource(
     private val httpClient: HttpClient
) {
    suspend fun getBooksByGenre(genre: Genre): BookResponse {
        return httpClient.get {
            parameter(Params.Q, "${Params.Q_SUBJECT}${genre.name}")
            parameter(Params.ORDER_BY, "relevance")
            parameter(Params.MAX_RESULTS, "16")
        }.body<BookResponse>()
    }
}
