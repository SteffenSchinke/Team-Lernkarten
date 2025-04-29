package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.lernkarten.team.ui.data.DataSource
import de.syntax_institut.lernkarten.team.ui.data.Deck
import de.syntax_institut.lernkarten.team.ui.navigation.FlashcardRoute
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.core.graphics.toColorInt

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
//            sts 29.04.25, is redundant - relocated in app navigation topbar
//            // Überschrift
//            Text(
//                "Meine Lernkarten",
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.padding(bottom = 16.dp)
//            )

            // Decks Liste
            DecksList(
                decks = DataSource.sampleDecks,
                onDeckClick = { deckId ->
                    // Navigation zum Deck mit seinen Lernkarten
                    navController.navigate(FlashcardRoute(deckId))
                }
            )
        }
    }
}

@Composable
fun DecksList(
    decks: List<Deck>,
    onDeckClick: (Long) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(decks) { deck ->
            DeckItem(
                deck = deck,
                onClick = { onDeckClick(deck.id) }
            )
        }
    }
}

@Composable
fun DeckItem(
    deck: Deck,
    onClick: () -> Unit,
) {
    val cardColor = remember { Color(deck.color.toColorInt()) }
    val dateFormatter = remember { SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()) }

    val lastModifiedDate by remember {
        derivedStateOf {
            dateFormatter.format(Date(deck.lastModified))
        }
    }

    val cardCount by remember {
        derivedStateOf {
            deck.flashcards.size
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Farbige Box als Indikator
            Box(
                modifier = Modifier
                    .size(width = 40.dp, height = 8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(cardColor)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Deck Name
            Text(
                text = deck.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Deck Beschreibung
            Text(
                text = deck.description,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Info Zeile
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Karten Anzahl
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$cardCount Karten",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Letztes Update
                Text(
                    text = "Aktualisiert: $lastModifiedDate",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    Home()
}