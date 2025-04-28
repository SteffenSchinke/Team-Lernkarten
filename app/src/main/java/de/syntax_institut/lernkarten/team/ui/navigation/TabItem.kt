package de.syntax_institut.lernkarten.team.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class TabItem(

    val route: Any,
    val tabTitle: String,
    val tabIcon: ImageVector
) {

    HOME(HomeRoute, "Home", Icons.Default.Home),
    SEARCH(LibraryRoute, "Library", Icons.AutoMirrored.Filled.List),
    SETTINGS(SettingsRoute, "Settings", Icons.Default.Settings)
}