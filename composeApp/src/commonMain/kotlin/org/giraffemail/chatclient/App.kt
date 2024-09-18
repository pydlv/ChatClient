package org.giraffemail.chatclient

import ChatIcon
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.giraffemail.chatclient.screens.SettingsScreen
import org.giraffemail.chatclient.screens.TopLevelChatScreen

enum class Route(val route: String) {
    Chats("chats"),
    Settings("settings")
}

data class RailOption(val text: String, val route: Route, val icon: ImageVector);

val topRailOptions: List<RailOption> = listOf(
    RailOption("Chat", Route.Chats, ChatIcon),
)

val bottomRailOptions: List<RailOption> = listOf(
    RailOption("Settings", Route.Settings, Icons.Sharp.Settings),
)

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val railOptions = @Composable { opts: List<RailOption> ->
        opts.forEach { option ->
            val isSelected = navBackStackEntry?.destination?.route == option.route.route
            NavigationRailItem(
                selected = isSelected,
                label = { Text(option.text) },
                icon = { Icon(option.icon, option.text) },
                onClick = {
                    navController.navigate(option.route.route)
                }
            )
        }
    }

    MaterialTheme {
        Row {
            NavigationRail(windowInsets = NavigationRailDefaults.windowInsets) {
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
                    Column {
                        railOptions(topRailOptions)
                    }

                    Column {
                        railOptions(bottomRailOptions)
                    }
                }
            }

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                NavHost(navController, startDestination = Route.Chats.route) {
                    composable(route = Route.Chats.route) { TopLevelChatScreen() }
                    composable(route = Route.Settings.route) { SettingsScreen() }
                }
            }
        }
    }
}