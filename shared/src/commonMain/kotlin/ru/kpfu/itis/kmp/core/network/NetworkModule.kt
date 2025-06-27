package ru.kpfu.itis.kmp.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpEngineFactory()
    }

    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }

    single(named(WITH_API_KEY_HTTP_CLIENT)) {
        buildHttpClient(
            engine = get<HttpEngineFactory>().createEngine(),
            json = get(),
            withApiKey = true
        )
    }

    single(named(WITHOUT_API_KEY_HTTP_CLIENT)) {
        buildHttpClient(
            engine = get<HttpEngineFactory>().createEngine(),
            json = get(),
            withApiKey = false
        )
    }
}

const val WITH_API_KEY_HTTP_CLIENT = "withApiKey"
const val WITHOUT_API_KEY_HTTP_CLIENT = "withoutApiKey"

const val BASE_HOST = "www.googleapis.com"
const val BASE_PATH = "books/v1/volumes/"


private fun buildHttpClient(
    engine: HttpClientEngineFactory<HttpClientEngineConfig>,
    json: Json,
    withApiKey: Boolean
) = HttpClient(engine) {
    if (withApiKey) {
        install(ApiKeyPlugin)
    }
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.BODY
    }
    install(ContentNegotiation) {
        json(json)
    }
    install(HttpTimeout) {
        connectTimeoutMillis = 10000
        requestTimeoutMillis = 10000
        socketTimeoutMillis = 10000
    }
    defaultRequest {
        url {
            this.host = BASE_HOST
            this.path(BASE_PATH)
            this.protocol = URLProtocol.HTTPS
        }
    }
}
