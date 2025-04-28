package de.syntax_institut.lernkarten.team.ui.data

// Modell für einen Kartenstapel/Deck
data class Deck(
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val lastModified: Long = System.currentTimeMillis(),
    val color: String = "#FFFFFF", // Farbcode für UI
    val flashcards: MutableList<Flashcard> = mutableListOf()
)