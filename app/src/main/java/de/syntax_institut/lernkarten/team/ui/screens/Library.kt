package de.syntax_institut.lernkarten.team.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.lernkarten.team.ui.components.DeckCard
import de.syntax_institut.lernkarten.team.ui.data.LibraryDeck

@Composable
fun Library() {
    var searchQuery by remember { mutableStateOf("") }
    val categories = listOf("Englisch", "Mathematik", "Wissenschaft", "Geschichte", "Biologie", "Chemie", "Physik")

    val sampleDecks = listOf(
        LibraryDeck("Englisch", "Unregelmäßige Verben", 42, "Anfänger"),
        LibraryDeck("Mathematik", "Lineare Algebra", 35, "Mittel"),
        LibraryDeck("Geschichte", "Zweiter Weltkrieg", 28, "Anfänger"),
        LibraryDeck("Biologie", "Menschlicher Körper", 50, "Fortgeschritten"),
        LibraryDeck("Chemie", "Periodensystem", 118, "Mittel")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Titel
        Text(
            text = "Lernkarten Deck Bibliothek",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Suchfeld
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Decks durchsuchen") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Suche") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Kategorien
        Text(
            text = "Kategorien",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Horizontale Kategorienliste
        LazyRow(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    selected = false,
                    onClick = { /* Kategorie auswählen */ },
                    modifier = Modifier.padding(end = 8.dp),
                    label = { Text(category) }
                )
            }
        }

        // Deck-Vorschläge
        Text(
            text = "Empfohlene Decks",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn {
            items(sampleDecks) { deck ->
                DeckCard(deck)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LibraryPreview() {
    Library()
}