package org.giraffemail.chatclient.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.*

enum class ChatScreens {
    ChatList,
    ChatInstance
}

@Composable
fun TopLevelChatScreen() {
    val navController = rememberNavController()
    val chatInstance: MutableState<ChatInstance?> = remember { mutableStateOf(null) }

    NavHost(navController, startDestination = ChatScreens.ChatList.name) {
        composable(route = ChatScreens.ChatList.name) { ChatListScreen(navController, chatInstance) }
        composable(route = ChatScreens.ChatInstance.name) {
            CompositionLocalProvider(ChatInstanceCompositionLocal provides chatInstance.value) {
                ChatInstanceScreen()
            }
        }
    }
}

@Composable
fun ChatListScreen(nav: NavController, chatInstance: MutableState<ChatInstance?>) {
    val chats = getDummyChats()

    LazyColumn {
        items(chats) { chat ->
            TextButton(
                content = {
                    Row(
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
                            Text(chat.timestamp.toString())
                            Text(chat.name)
                        }
                    }
                },
                onClick = {
                    chatInstance.value = chat
                    nav.navigate(ChatScreens.ChatInstance.name)
                }
            )
        }
    }
}

fun getDummyChats(): List<ChatInstance> {
    return listOf(
        ChatInstance("1", Date.from(Date().toInstant()), name = "Untitled chat"),
        ChatInstance("2", Date.from(Date().toInstant().minusSeconds(3600)), name = "General Discussion"),
        ChatInstance("3", Date.from(Date().toInstant().minusSeconds(7200)), name = "Project Updates"),
        ChatInstance("4", Date.from(Date().toInstant().minusSeconds(10800)), name = "Random Chatter"),
        ChatInstance("5", Date.from(Date().toInstant().minusSeconds(14400)), name = "Tech Talk")
    )
}