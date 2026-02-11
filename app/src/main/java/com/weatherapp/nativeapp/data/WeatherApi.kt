package com.weatherapp.nativeapp.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class WeatherApi {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchWeather(city: String): WeatherResponse {
        // wttr.in uses path-based city names and ?format=j1 for JSON
        return client.get("https://wttr.in/${city.trim()}") {
            parameter("format", "j1")
        }.body()
    }
    
    fun close() {
        client.close()
    }
}
