package org.giraffemail.chatclient.screens


import RobotIcon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class Sender {
    User,
    Bot
}

data class Message(val sender: Sender, val content: String)

val messages = listOf(
    Message(Sender.User, "Hi AI, how are you today?"),
    Message(Sender.Bot, "Hello User, I am here to assist you. How can I help you today?"),
    Message(Sender.User, "Great! I have a few questions about the project."),
    Message(Sender.Bot, "Of course. Please go ahead with your questions."),
    Message(Sender.User, "How do I integrate the API into the application?"),
    Message(
        Sender.Bot,
        "You can start by importing the necessary libraries and setting up your project configuration."
    ),
    Message(Sender.User, "Can you provide an example?"),
    Message(Sender.Bot, "Sure, let me pull up an example for you."),
    Message(Sender.Bot, "Here's a basic example of API integration..."),
    Message(Sender.User, "Thanks, that helps a lot."),
    Message(Sender.User, "Also, I encountered a bug. The app crashes on launch sometimes."),
    Message(Sender.Bot, "Let's debug it together. Can you show me the error log?"),
    Message(Sender.User, "Sure, let me paste the log... [log pasted]"),
    Message(
        Sender.Bot,
        "It seems like there's a null pointer exception. Make sure all the variables are properly initialized."
    ),
    Message(Sender.User, "That makes sense. I'll check my initialization."),
    Message(Sender.User, "Another question, how do I optimize the performance of my app?"),
    Message(
        Sender.Bot,
        "You can start by profiling your app to identify bottlenecks and then apply optimizations like lazy loading, using efficient data structures, etc."
    ),
    Message(Sender.User, "Got it. I'll try those optimizations."),
    Message(Sender.User, "Thanks for your help, AI. I think I can handle it from here."),
    Message(Sender.Bot, "You're welcome. Feel free to reach out if you have more questions. Have a great day!")
)

@Composable
fun ChatInstanceScreen() {
    Column(modifier = Modifier.padding(horizontal = 8.dp).fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            messages.forEach { message ->
                MessageRow(message)
            }
        }

        MessageBox(
            Modifier
                .padding(top = 8.dp)
                .fillMaxHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
fun MessageBox(modifier: Modifier = Modifier) {
    val textValue = remember { mutableStateOf("") }

    TextField(
        value = textValue.value,
        onValueChange = { newValue: String -> textValue.value = newValue },
        label = @Composable { Text("Enter message...") },
        singleLine = false,
        modifier = modifier,
    )
}

@Composable
fun MessageRow(message: Message) {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(horizontal = 4.dp)) {
            Icon(
                imageVector =
                if (message.sender == Sender.User) Icons.Sharp.Person
                else RobotIcon,
                contentDescription = if (message.sender == Sender.User) "User" else "AI"
            )
        }
        Text(message.content)
    }
}