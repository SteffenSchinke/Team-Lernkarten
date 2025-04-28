package de.syntax_institut.lernkarten.team.ui.data

// Modell für Benutzer (falls deine App mehrere Benutzer unterstützt)
data class User(
    val id: Long = 0,
    val username: String,
    val email: String,
    val createdAt: Long = System.currentTimeMillis(),
    val decks: MutableList<Deck> = mutableListOf()
)