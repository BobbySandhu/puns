package com.bobbysandhu.pun

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform