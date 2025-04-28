package de.syntax_institut.lernkarten.team

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import de.syntax_institut.lernkarten.team.ui.navigation.AppNavigator
import de.syntax_institut.lernkarten.team.ui.theme.LernkartenTheme
import de.syntax_institut.lernkarten.team.ui.viewmodels.SettingsVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isDarkTheme by SettingsVM.isDarkTheme.collectAsState()

            LernkartenTheme(darkTheme = isDarkTheme) {

                AppNavigator()
            }
        }
    }
}