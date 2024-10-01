package com.bobbysandhu.pun

import io.ktor.client.statement.bodyAsText

class Greeting {

    suspend fun greet(): String {
        return "hello greeting"
    }
}