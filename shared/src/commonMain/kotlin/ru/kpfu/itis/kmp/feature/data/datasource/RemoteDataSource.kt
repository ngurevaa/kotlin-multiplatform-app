package ru.kpfu.itis.kmp.feature.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class RemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getText() = httpClient.get("https://ktor.io/docs/").bodyAsText()
}
