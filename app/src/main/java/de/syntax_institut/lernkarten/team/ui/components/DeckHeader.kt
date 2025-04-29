package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.data.Deck

@Composable
fun DeckHeader(deck: Deck) {
    Column {

//            sts 29.04.25, is redundant - relocated in app navigation topbar
//        // Deck Name
//        Text(
//            text = deck.name,
//            style = MaterialTheme.typography.headlineMedium,
//            fontWeight = FontWeight.Companion.Bold
//        )

        // Deck Beschreibung
        Text(
            text = deck.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.Companion.padding(top = 4.dp)
        )

        // Deck Info
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Text(
                text = "${deck.flashcards.size} Karten",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}