package de.syntax_institut.lernkarten.team.ui.data

// Modell für Spaced-Repetition-Algorithmus (basierend auf SM-2)
data class SpacedRepetitionData(
    val flashcardId: Long,
    var easeFactor: Double = 2.5, // Startwert für den Leichtigkeitsfaktor
    var intervalDays: Double = 0.0,    // Tage bis zur nächsten Wiederholung
    var consecutiveCorrect: Int = 0 // Anzahl der aufeinanderfolgenden korrekten Antworten
)
