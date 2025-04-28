package de.syntax_institut.lernkarten.team.ui.data

// Modell für eine Lernsitzung
data class StudySession(
    val id: Long = 0,
    val deckId: Long,
    val startTime: Long = System.currentTimeMillis(),
    val endTime: Long? = null,
    val cardsReviewed: MutableList<FlashcardReview> = mutableListOf()
)