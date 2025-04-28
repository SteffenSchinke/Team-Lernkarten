package de.syntax_institut.lernkarten.team.ui.data

// Modell für Tags/Kategorien
data class Tag(
    val id: Long = 0,
    val name: String,
    val color: String = "#000000"
)