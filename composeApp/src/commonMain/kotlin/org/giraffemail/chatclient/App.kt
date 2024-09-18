package org.giraffemail.chatclient

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.giraffemail.chatclient.screens.ChatListScreen
import org.giraffemail.chatclient.screens.SettingsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Route(val route: String) {
    Chats("chats"),
    Settings("settings")
}

data class DrawerOption(val text: String, val route: Route);

val options: List<DrawerOption> = listOf(
    DrawerOption("Chats", Route.Chats),
    DrawerOption("Settings", Route.Settings),
)

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    MaterialTheme {
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
            Text(
                text = "ChatClient",
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
            Divider()
            options.forEach { option ->
                val isSelected = navBackStackEntry?.destination?.route == option.route.route
                TextButton(
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface,
                        backgroundColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.surface
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    content = { Text(option.text) },
                    onClick = {
                        navController.navigate(option.route.route)
                        scope.launch { drawerState.close() }
                    }
                )
            }
            }
        ) {
            NavHost(navController, startDestination = Route.Chats.route) {
                composable(route=Route.Chats.route) { ChatListScreen() }
                composable(route=Route.Settings.route) { SettingsScreen() }
            }
        }
    }
}