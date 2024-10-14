package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import com.example.plugins.*

fun Application.module() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    install(CORS) {
        allowHost("localhost:3000")
        allowCredentials = true
        allowHeader("Content-Type")
    }

    configureRouting()
}