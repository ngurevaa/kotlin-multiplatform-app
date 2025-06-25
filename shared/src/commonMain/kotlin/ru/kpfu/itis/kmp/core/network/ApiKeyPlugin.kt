package ru.kpfu.itis.kmp.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.util.AttributeKey
import io.ktor.client.request.HttpRequestPipeline.Phases.Before

class ApiKeyPlugin {

    companion object Plugin : HttpClientPlugin<Unit, ApiKeyPlugin> {

        override val key: AttributeKey<ApiKeyPlugin>
            get() = AttributeKey(name = Params.API_KEY)

        override fun prepare(block: Unit.() -> Unit): ApiKeyPlugin {
            return ApiKeyPlugin()
        }

        override fun install(plugin: ApiKeyPlugin, scope: HttpClient) {
            scope.requestPipeline.intercept(Before) {
                context.url.parameters.append(Params.API_KEY, "AIzaSyBw8i0XVAHNsgIhb-PljmDU_hIJ7J6VFT4")
            }
        }
    }
}
