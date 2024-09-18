package org.giraffemail.chatclient

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.giraffemail.chatclient.screens.ChatsScreen
import org.giraffemail.chatclient.screens.SettingsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Route(val route: String) {
    Chats("chats"),
    Settings("settings")
}

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    MaterialTheme {
        ModalDrawer(drawerContent = {
            Text("ChatClient")
            Divider()
            NavigationRailItem(
                label= { Text("Chats") },
                icon={},
                selected=navBackStackEntry?.destination?.route == Route.Chats.route,
                onClick = {
                    navController.navigate(Route.Chats.route)
                }
            )
            NavigationRailItem(
                label= { Text("Settings") },
                icon={},
                selected=navBackStackEntry?.destination?.route == Route.Settings.route,
                onClick = {
                    navController.navigate(Route.Settings.route)
                }
            )
        }) {
            NavHost(navController, startDestination = Route.Chats.route) {
                composable(route=Route.Chats.route) { ChatsScreen() }
                composable(route=Route.Settings.route) { SettingsScreen() }
            }
        }
    }
}