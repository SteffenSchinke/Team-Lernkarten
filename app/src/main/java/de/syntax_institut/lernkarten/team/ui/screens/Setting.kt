package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.components.GeneralSettings
import de.syntax_institut.lernkarten.team.ui.components.ProfileSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setting() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ProfileSection()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Kontoverwaltung öffnen */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Konto verwalten")
        }

        Spacer(modifier = Modifier.height(24.dp))

        GeneralSettings()
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SettingPreview() {

    Setting()
}