package de.syntax_institut.lernkarten.team.ui.extension

import androidx.compose.ui.graphics.Color

fun Color.toHex(): String {

    val red = (red * 255).toInt().coerceIn(0, 255)
    val green = (green * 255).toInt().coerceIn(0, 255)
    val blue = (blue * 255).toInt().coerceIn(0, 255)

    return String.format("#%02X%02X%02X", red, green, blue)
}