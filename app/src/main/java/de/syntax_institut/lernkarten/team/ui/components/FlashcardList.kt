package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.data.Flashcard

@Composable
fun FlashcardList(
    flashcards: List<Flashcard>,
    deckColor: String
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(flashcards) { flashcard ->
            FlashcardItem(
                flashcard = flashcard,
                deckColor = deckColor
            )
        }
    }
}