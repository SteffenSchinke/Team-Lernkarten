package de.syntax_institut.lernkarten.team.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Startseite") },
                    label = { Text("Startseite") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Einstellungen") },
                    label = { Text("Einstellungen") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1}
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedIndex) {
                0 -> StartseiteContent()
                2 -> EinstellungenContent()
            }
        }
    }
}

@Composable
fun StartseiteContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Neues Deck erstellen oder aus Bibliothek hinzufügen")
        Spacer(modifier = Modifier.height(16.dp))
        FloatingActionButton(
            onClick = { /* TODO: Neues Deck erstellen */ },
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Default.Home, contentDescription = "Neues Deck")
        }
    }
}

@Composable
fun BibliothekContent() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Bibliothek wird hier angezeigt")
    }
}

@Composable
fun EinstellungenContent() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Einstellungen")
    }
}

@Preview(showBackground = true)
@Composable
fun StartseiteScreenPreview() {
    Home()
}
