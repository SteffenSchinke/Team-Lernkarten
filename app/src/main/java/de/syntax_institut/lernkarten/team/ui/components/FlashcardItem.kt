package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.data.Flashcard
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.core.graphics.toColorInt

@Composable
fun FlashcardItem(
    flashcard: Flashcard,
    deckColor: String,
) {
    val cardColor = remember { androidx.compose.ui.graphics.Color(deckColor.toColorInt()) }
    val dateFormatter = remember { SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()) }

    // Status für Kartenansicht
    var showAnswer by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .clickable { showAnswer = !showAnswer },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.Companion.padding(16.dp)
        ) {
            // Farbiger Indikator
            Box(
                modifier = Modifier.Companion
                    .size(width = 40.dp, height = 4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(cardColor)
            )

            Spacer(modifier = Modifier.Companion.height(12.dp))

            // Frage
            Text(
                text = flashcard.question,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Companion.Bold
            )

            // Antwort (wenn angezeigt werden soll)
            if (showAnswer) {
                Spacer(modifier = Modifier.Companion.height(12.dp))

                Text(
                    text = "Antwort:",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.Companion.height(4.dp))

                Text(
                    text = flashcard.answer,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.Companion.height(8.dp))

            // Info zu letztem Review
            Row(
                modifier = Modifier.Companion.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Companion.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.Companion.size(14.dp)
                )

                Spacer(modifier = Modifier.Companion.padding(horizontal = 4.dp))

                Text(
                    text = flashcard.lastReviewed?.let {
                        "Zuletzt gelernt: ${dateFormatter.format(Date(it))}"
                    } ?: "Noch nicht gelernt",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}