package org.giraffemail.chatclient.screens

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import java.util.*

data class ChatInstance(
    val chatId: String,
    val timestamp: Date,
    val name: String
)

val ChatInstanceCompositionLocal: ProvidableCompositionLocal<ChatInstance?> = compositionLocalOf { null }