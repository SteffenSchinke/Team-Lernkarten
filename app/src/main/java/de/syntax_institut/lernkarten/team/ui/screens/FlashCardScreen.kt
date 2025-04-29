package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.c.FlashcardList
import de.syntax_institut.lernkarten.team.ui.components.DeckHeader
import de.syntax_institut.lernkarten.team.ui.data.DataSource

@Composable
fun FlashcardScreen(
    deckId: Long,
    modifier: Modifier = Modifier
) {
    // Deck abrufen
    val deck = remember(deckId) {
        DataSource.getDeckById(deckId)
    }

    if (deck != null) {
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Deck Information
                DeckHeader(deck = deck)

                Spacer(modifier = Modifier.height(16.dp))

                // Flashcards
                FlashcardList(
                    flashcards = deck.flashcards,
                    deckColor = deck.color
                )
            }
        }
    } else {
        // Fallback wenn das Deck nicht gefunden wurde
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Deck nicht gefunden")
            }
        }
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FlashcardScreenPreview() {
    // Verwende das erste Deck für die Vorschau
    FlashcardScreen(deckId = 1)
}