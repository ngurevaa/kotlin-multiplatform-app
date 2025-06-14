package ru.kpfu.itis.kmp.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.request.HttpRequestPipeline.Phases.Before
import io.ktor.util.AttributeKey

private const val API_KEY_NAME = "key"

class ApiKeyPlugin {

    companion object Plugin : HttpClientPlugin<Unit, ApiKeyPlugin> {

        override val key: AttributeKey<ApiKeyPlugin>
            get() = AttributeKey(name = API_KEY_NAME)

        override fun prepare(block: Unit.() -> Unit): ApiKeyPlugin {
            return ApiKeyPlugin()
        }

        override fun install(plugin: ApiKeyPlugin, scope: HttpClient) {
            scope.requestPipeline.intercept(Before) {
                context.url.parameters.append(API_KEY_NAME, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
            }
        }
    }
}
