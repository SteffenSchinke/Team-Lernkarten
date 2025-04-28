package de.syntax_institut.lernkarten.team.ui.data

// Modell für Lernstatistiken
data class StudyStats(
    val userId: Long,
    val deckId: Long,
    val cardsStudied: Int,
    val correctAnswers: Int,
    val incorrectAnswers: Int,
    val studyDate: Long = System.currentTimeMillis()
)