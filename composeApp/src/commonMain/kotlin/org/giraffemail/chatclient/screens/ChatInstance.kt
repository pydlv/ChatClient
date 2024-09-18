package org.giraffemail.chatclient.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class Message(val sender: String, val content: String)

val messages = listOf(
    Message("User", "Hi AI, how are you today?"),
    Message("AI", "Hello User, I am here to assist you. How can I help you today?"),
    Message("User", "Great! I have a few questions about the project."),
    Message("AI", "Of course. Please go ahead with your questions."),
    Message("User", "How do I integrate the API into the application?"),
    Message("AI", "You can start by importing the necessary libraries and setting up your project configuration."),
    Message("User", "Can you provide an example?"),
    Message("AI", "Sure, let me pull up an example for you."),
    Message("AI", "Here's a basic example of API integration..."),
    Message("User", "Thanks, that helps a lot."),
    Message("User", "Also, I encountered a bug. The app crashes on launch sometimes."),
    Message("AI", "Let's debug it together. Can you show me the error log?"),
    Message("User", "Sure, let me paste the log... [log pasted]"),
    Message(
        "AI",
        "It seems like there's a null pointer exception. Make sure all the variables are properly initialized."
    ),
    Message("User", "That makes sense. I'll check my initialization."),
    Message("User", "Another question, how do I optimize the performance of my app?"),
    Message(
        "AI",
        "You can start by profiling your app to identify bottlenecks and then apply optimizations like lazy loading, using efficient data structures, etc."
    ),
    Message("User", "Got it. I'll try those optimizations."),
    Message("User", "Thanks for your help, AI. I think I can handle it from here."),
    Message("AI", "You're welcome. Feel free to reach out if you have more questions. Have a great day!")
)

@Composable
fun ChatInstanceScreen() {
    Column {
        messages.forEach { message ->
            MessageRow(message)
        }
    }
}

@Composable
fun MessageRow(message: Message) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column {

        }
        Text(message.sender)
        Text(message.content)
    }
}