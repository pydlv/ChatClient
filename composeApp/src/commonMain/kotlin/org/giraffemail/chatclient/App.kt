package org.giraffemail.chatclient

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Edit
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

data class MenuItem(val text: String, val route: Route, val icon: ImageVector);

val topOptions: List<MenuItem> = listOf(
    MenuItem("Back", Route.Chats, Icons.AutoMirrored.Sharp.ArrowBack),
    MenuItem("Chats", Route.Chats, Icons.Sharp.Edit),
)

val bottomOptions: List<MenuItem> = listOf(
    MenuItem("Settings", Route.Settings, Icons.Sharp.Settings),
)

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    MaterialTheme {
        Row {
            NavigationRail {
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
                    Column {
                        topOptions.forEach { option ->
                            val isSelected = navBackStackEntry?.destination?.route == option.route.route
                            NavigationRailItem(
                                selected = isSelected,
                                label = { option.text },
                                icon = { Icon(option.icon, option.text) },
                                onClick = {
                                    navController.navigate(option.route.route)
                                }
                            )
                        }

                    }

                    Column {
                        bottomOptions.forEach { option ->
                            val isSelected = navBackStackEntry?.destination?.route == option.route.route
                            NavigationRailItem(
                                selected = isSelected,
                                label = { option.text },
                                icon = { Icon(option.icon, option.text) },
                                onClick = {
                                    navController.navigate(option.route.route)
                                }
                            )
                        }
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