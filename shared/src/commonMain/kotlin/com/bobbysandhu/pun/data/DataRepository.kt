package com.bobbysandhu.pun.data

import com.bobbysandhu.pun.getPlatform
import com.bobbysandhu.pun.models.Joke
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class DataRepository {
    private val platform = getPlatform()

    @OptIn(ExperimentalSerializationApi::class)
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = true
            })
        }
    }

    suspend fun getRandomJokes(): List<Joke> {
        return httpClient.get("https://official-joke-api.appspot.com/jokes/random/25").body()
    }
}