package org.giraffemail.chatclient

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        ModalDrawer(drawerContent = {
            Text("ChatClient")
            Divider()
            NavigationRailItem(
                label= { Text("Settings") },
                icon={},
                selected=true,
                onClick = {}
            )
        }) {
            Text("Content")
        }
    }
}