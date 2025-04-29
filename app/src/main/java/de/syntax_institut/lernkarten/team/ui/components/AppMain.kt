package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.syntax_institut.lernkarten.team.ui.navigation.AppNavigator
import de.syntax_institut.lernkarten.team.ui.screens.AppLaunch
import kotlin.time.Duration.Companion.seconds

@Composable
fun AppMain() {

    var showLauncher by remember { mutableStateOf(true) }

    if (showLauncher) {

        AppLaunch(
            duration = 5.seconds,
            onLaunchComplete = { showLauncher = false }
        )
    } else {

        AppNavigator()
    }
}