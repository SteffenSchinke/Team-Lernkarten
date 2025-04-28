package de.syntax_institut.lernkarten.team.ui.data

// Grundlegendes Modell für eine Lernkarte
data class Flashcard(
    val id: Long = 0,
    val question: String,
    val answer: String,
    val difficulty: Difficulty = Difficulty.MEDIUM,
    val createdAt: Long = System.currentTimeMillis(),
    val lastReviewed: Long? = null,
    val nextReviewDate: Long? = null,
    var reviewCount: Int = 0
)