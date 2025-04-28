package de.syntax_institut.lernkarten.team.ui.data

// Verbindungsklasse für Karten und Tags (Many-to-Many-Beziehung)
data class FlashcardTagCrossRef(
    val flashcardId: Long,
    val tagId: Long
)