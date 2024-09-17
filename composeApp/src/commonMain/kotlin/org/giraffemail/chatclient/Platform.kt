package org.giraffemail.chatclient

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform