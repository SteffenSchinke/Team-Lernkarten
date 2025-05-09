package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.lernkarten.team.ui.viewmodels.SettingsVM

@Composable
fun GeneralSettings() {
    val isDarkTehem by SettingsVM.isDarkTheme.collectAsState()
    val notificationsEnabled = remember { mutableStateOf(true) }

    Column {
        Text(
            "Allgemeine Einstellungen",
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Spracheinstellung mit Wert rechts
        SettingItem(
            name = "Sprache",
            value = "Deutsch",
            onClick = { /* Sprache ändern */ }
        )

        // Nachtmodus
        SettingItem(
            name = "Nachtmodus",
            action = {
                Switch(
                    checked = isDarkTehem,
                    onCheckedChange = SettingsVM::toggleThemeMode,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        )

        // Benachrichtigungen
        SettingItem(
            name = "Benachrichtigungen",
            action = {
                Switch(
                    checked = notificationsEnabled.value,
                    onCheckedChange = { notificationsEnabled.value = it },
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GerenralSettingView() {
    GeneralSettings()
}