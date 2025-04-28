package de.syntax_institut.lernkarten.team.ui.data

// Modell für die Bewertung einer Karte während einer Lernsitzung
data class FlashcardReview(
    val flashcardId: Long,
    val reviewTime: Long = System.currentTimeMillis(),
    val userRating: UserRating
)