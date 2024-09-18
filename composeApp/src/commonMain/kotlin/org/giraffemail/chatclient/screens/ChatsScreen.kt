package org.giraffemail.chatclient.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

data class Chat(val id: Int, val name: String, val lastMessage: String)

@Composable
fun ChatListScreen() {
    val chats = getDummyChats()

    LazyColumn {
        items(chats) { chat ->
            ChatItem(chat)
        }
    }
}

@Composable
fun ChatItem(chat: Chat) {
    Row {
        Column {
            ChatText(chat.name)
        }
        Column {
            ChatText(chat.lastMessage)
        }
    }
}

@Composable
fun ChatText(text: String) {
    Text(text = text)
}

fun getDummyChats(): List<Chat> {
    return listOf(
        Chat(1, "Alice", "Hey! How are you?"),
        Chat(2, "Bob", "Let's catch up sometime next week."),
        Chat(3, "Charlie", "Did you finish the project?"),
        Chat(4, "Diana", "Happy Birthday! 🎉"),
        Chat(5, "Eddie", "Can we reschedule our meeting?")
    )
}