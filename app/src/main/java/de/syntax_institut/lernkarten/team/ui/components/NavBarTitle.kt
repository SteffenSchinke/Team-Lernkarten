package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NavBarTitle(title: String) {

    Text(title, style = MaterialTheme.typography.displaySmall)
}