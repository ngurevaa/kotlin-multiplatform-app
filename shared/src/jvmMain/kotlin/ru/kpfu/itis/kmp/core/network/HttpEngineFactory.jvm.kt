package ru.kpfu.itis.kmp.core.network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.apache5.Apache5

actual open class HttpEngineFactory actual constructor() {

    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
        return Apache5
    }
}
