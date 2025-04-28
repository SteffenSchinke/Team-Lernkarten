package de.syntax_institut.lernkarten.team.ui.data

import java.util.concurrent.TimeUnit

/**
 * Dummy-Datenquelle für die App-Entwicklung und Tests
 */
object DataSource {

    // Aktuelle Zeit als Basis für alle Timestamps
    private val currentTime = System.currentTimeMillis()

    // Einen Tag in Millisekunden für einfachere Zeitberechnungen
    private val DAY_IN_MILLIS = TimeUnit.DAYS.toMillis(1)

    // Beispiel-Decks
    val sampleDecks = listOf(
        Deck(
            id = 1,
            name = "Programmierung Grundlagen",
            description = "Grundlegende Konzepte der Programmierung",
            createdAt = currentTime - DAY_IN_MILLIS * 30, // erstellt vor 30 Tagen
            lastModified = currentTime - DAY_IN_MILLIS * 2, // zuletzt vor 2 Tagen bearbeitet
            color = "#4CAF50", // Grün
            flashcards = mutableListOf(
                Flashcard(
                    id = 1,
                    question = "Was ist eine Variable?",
                    answer = "Ein benannter Speicherplatz für Daten, deren Wert sich während der Programmausführung ändern kann.",
                    createdAt = currentTime - DAY_IN_MILLIS * 30,
                    lastReviewed = currentTime - DAY_IN_MILLIS * 5,
                    nextReviewDate = currentTime + DAY_IN_MILLIS * 2,
                    reviewCount = 3
                ),
                Flashcard(
                    id = 2,
                    question = "Was ist der Unterschied zwischen val und var in Kotlin?",
                    answer = "var definiert eine veränderbare Variable, während val eine unveränderliche (Read-only) Variable definiert.",
                    createdAt = currentTime - DAY_IN_MILLIS * 30,
                    lastReviewed = currentTime - DAY_IN_MILLIS * 3,
                    nextReviewDate = currentTime + DAY_IN_MILLIS * 4,
                    reviewCount = 2
                ),
                Flashcard(
                    id = 3,
                    question = "Was ist eine Funktion?",
                    answer = "Ein benannter, wiederverwendbarer Codeblock, der eine bestimmte Aufgabe ausführt.",
                    createdAt = currentTime - DAY_IN_MILLIS * 28,
                    lastReviewed = null,
                    nextReviewDate = null,
                    reviewCount = 0
                )
            )
        ),
        Deck(
            id = 2,
            name = "Kotlin Fortgeschritten",
            description = "Fortgeschrittene Konzepte in Kotlin",
            createdAt = currentTime - DAY_IN_MILLIS * 15,
            lastModified = currentTime - DAY_IN_MILLIS,
            color = "#2196F3", // Blau
            flashcards = mutableListOf(
                Flashcard(
                    id = 4,
                    question = "Was sind Higher-Order Functions?",
                    answer = "Funktionen, die andere Funktionen als Parameter akzeptieren oder als Rückgabewert zurückgeben können.",
                    createdAt = currentTime - DAY_IN_MILLIS * 15,
                    lastReviewed = currentTime - DAY_IN_MILLIS * 2,
                    nextReviewDate = currentTime + DAY_IN_MILLIS * 6,
                    reviewCount = 4
                ),
                Flashcard(
                    id = 5,
                    question = "Was sind Coroutines in Kotlin?",
                    answer = "Leichtgewichtige Threads für asynchrone und nicht-blockierende Programmierung.",
                    createdAt = currentTime - DAY_IN_MILLIS * 10,
                    lastReviewed = currentTime - DAY_IN_MILLIS,
                    nextReviewDate = currentTime + DAY_IN_MILLIS * 3,
                    reviewCount = 5
                )
            )
        ),
        Deck(
            id = 3,
            name = "Android UI",
            description = "Android Benutzeroberflächen und Layouts",
            createdAt = currentTime - DAY_IN_MILLIS * 20,
            lastModified = currentTime - DAY_IN_MILLIS * 5,
            color = "#FF5722", // Orange
            flashcards = mutableListOf(
                Flashcard(
                    id = 6,
                    question = "Was ist Jetpack Compose?",
                    answer = "Ein modernes UI-Toolkit für Android, das einen deklarativen Ansatz für die UI-Erstellung verwendet.",
                    createdAt = currentTime - DAY_IN_MILLIS * 20,
                    lastReviewed = currentTime - DAY_IN_MILLIS * 7,
                    nextReviewDate = currentTime + DAY_IN_MILLIS,
                    reviewCount = 2
                ),
                Flashcard(
                    id = 7,
                    question = "Was ist der Unterschied zwischen ConstraintLayout und LinearLayout?",
                    answer = "ConstraintLayout erlaubt flexible Positionierung mit Constraints zwischen Views, während LinearLayout Views linear (horizontal oder vertikal) anordnet.",
                    createdAt = currentTime - DAY_IN_MILLIS * 18,
                    lastReviewed = currentTime - DAY_IN_MILLIS * 4,
                    nextReviewDate = currentTime + DAY_IN_MILLIS * 5,
                    reviewCount = 3
                )
            )
        )
    )

    // Beispiel für Spaced-Repetition-Daten
    val sampleSpacedRepetitionData = listOf(
        SpacedRepetitionData(
            flashcardId = 1,
            easeFactor = 2.7,
            intervalDays = 4.0,
            consecutiveCorrect = 2
        ),
        SpacedRepetitionData(
            flashcardId = 2,
            easeFactor = 2.3,
            intervalDays = 2.0,
            consecutiveCorrect = 1
        ),
        SpacedRepetitionData(
            flashcardId = 4,
            easeFactor = 2.9,
            intervalDays = 8.0,
            consecutiveCorrect = 3
        ),
        SpacedRepetitionData(
            flashcardId = 5,
            easeFactor = 3.1,
            intervalDays = 6.0,
            consecutiveCorrect = 2
        ),
        SpacedRepetitionData(
            flashcardId = 6,
            easeFactor = 2.4,
            intervalDays = 3.0,
            consecutiveCorrect = 1
        ),
        SpacedRepetitionData(
            flashcardId = 7,
            easeFactor = 2.6,
            intervalDays = 5.0,
            consecutiveCorrect = 2
        )
    )

    // Beispiel-Lernsitzungen
    val sampleStudySessions = listOf(
        StudySession(
            id = 1,
            deckId = 1,
            startTime = currentTime - DAY_IN_MILLIS * 5 - TimeUnit.HOURS.toMillis(2),
            endTime = currentTime - DAY_IN_MILLIS * 5 - TimeUnit.HOURS.toMillis(1),
            cardsReviewed = mutableListOf(
                FlashcardReview(
                    flashcardId = 1,
                    reviewTime = currentTime - DAY_IN_MILLIS * 5 - TimeUnit.HOURS.toMillis(2) + TimeUnit.MINUTES.toMillis(5),
                    userRating = UserRating.GOOD
                ),
                FlashcardReview(
                    flashcardId = 2,
                    reviewTime = currentTime - DAY_IN_MILLIS * 5 - TimeUnit.HOURS.toMillis(2) + TimeUnit.MINUTES.toMillis(12),
                    userRating = UserRating.HARD
                )
            )
        ),
        StudySession(
            id = 2,
            deckId = 2,
            startTime = currentTime - DAY_IN_MILLIS * 2 - TimeUnit.HOURS.toMillis(3),
            endTime = currentTime - DAY_IN_MILLIS * 2 - TimeUnit.HOURS.toMillis(2),
            cardsReviewed = mutableListOf(
                FlashcardReview(
                    flashcardId = 4,
                    reviewTime = currentTime - DAY_IN_MILLIS * 2 - TimeUnit.HOURS.toMillis(3) + TimeUnit.MINUTES.toMillis(7),
                    userRating = UserRating.EASY
                ),
                FlashcardReview(
                    flashcardId = 5,
                    reviewTime = currentTime - DAY_IN_MILLIS * 2 - TimeUnit.HOURS.toMillis(3) + TimeUnit.MINUTES.toMillis(15),
                    userRating = UserRating.GOOD
                )
            )
        ),
        StudySession(
            id = 3,
            deckId = 1,
            startTime = currentTime - DAY_IN_MILLIS - TimeUnit.HOURS.toMillis(1),
            endTime = currentTime - DAY_IN_MILLIS - TimeUnit.MINUTES.toMillis(30),
            cardsReviewed = mutableListOf(
                FlashcardReview(
                    flashcardId = 1,
                    reviewTime = currentTime - DAY_IN_MILLIS - TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(10),
                    userRating = UserRating.GOOD
                ),
                FlashcardReview(
                    flashcardId = 2,
                    reviewTime = currentTime - DAY_IN_MILLIS - TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(18),
                    userRating = UserRating.GOOD
                ),
                FlashcardReview(
                    flashcardId = 3,
                    reviewTime = currentTime - DAY_IN_MILLIS - TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(25),
                    userRating = UserRating.AGAIN
                )
            )
        )
    )

    // Beispiel-Lernstatistiken
    val sampleStudyStats = listOf(
        StudyStats(
            userId = 1,
            deckId = 1,
            cardsStudied = 2,
            studyDate = currentTime - DAY_IN_MILLIS * 5
        ),
        StudyStats(
            userId = 1,
            deckId = 2,
            cardsStudied = 2,
            studyDate = currentTime - DAY_IN_MILLIS * 2
        ),
        StudyStats(
            userId = 1,
            deckId = 1,
            cardsStudied = 3,
            studyDate = currentTime - DAY_IN_MILLIS
        ),
        StudyStats(
            userId = 1,
            deckId = 3,
            cardsStudied = 1,
            studyDate = currentTime - DAY_IN_MILLIS * 7
        ),
        StudyStats(
            userId = 1,
            deckId = 3,
            cardsStudied = 2,
            studyDate = currentTime - DAY_IN_MILLIS * 4
        )
    )

    // Hilfsfunktion, um alle Flashcards zu erhalten
    fun getAllFlashcards(): List<Flashcard> {
        return sampleDecks.flatMap { it.flashcards }
    }

    // Hilfsfunktion, um ein Deck anhand seiner ID zu finden
    fun getDeckById(id: Long): Deck? {
        return sampleDecks.find { it.id == id }
    }

    // Hilfsfunktion, um eine Flashcard anhand ihrer ID zu finden
    fun getFlashcardById(id: Long): Flashcard? {
        return getAllFlashcards().find { it.id == id }
    }

    // Hilfsfunktion, um SpacedRepetitionData für eine Flashcard zu finden
    fun getSpacedRepetitionForCard(flashcardId: Long): SpacedRepetitionData? {
        return sampleSpacedRepetitionData.find { it.flashcardId == flashcardId }
    }

    // Hilfsfunktion, um Lernsitzungen für ein bestimmtes Deck zu finden
    fun getStudySessionsForDeck(deckId: Long): List<StudySession> {
        return sampleStudySessions.filter { it.deckId == deckId }
    }

    // Hilfsfunktion, um Statistiken für einen bestimmten Nutzer zu erhalten
    fun getStatsForUser(userId: Long): List<StudyStats> {
        return sampleStudyStats.filter { it.userId == userId }
    }
}