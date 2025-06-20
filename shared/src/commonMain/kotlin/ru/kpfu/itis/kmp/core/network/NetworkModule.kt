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
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import kotlin.math.sin

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

    single {
        buildHttpClient(
            engine = get<HttpEngineFactory>().createEngine(),
            json = get()
        )
    }
}

private const val BASE_HOST = "www.googleapis.com"
private const val BASE_PATH = "books/v1/volumes"


private fun buildHttpClient(
    engine: HttpClientEngineFactory<HttpClientEngineConfig>,
    json: Json,
) = HttpClient(engine) {
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
