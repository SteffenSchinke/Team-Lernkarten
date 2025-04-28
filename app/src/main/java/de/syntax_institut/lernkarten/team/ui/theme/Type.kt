package de.syntax_institut.lernkarten.team.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import de.syntax_institut.lernkarten.team.R

val novaSquareFontFamily = FontFamily(
    Font(R.font.nova_square_regular)
)

val baseline = Typography()

val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = novaSquareFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = novaSquareFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = novaSquareFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = novaSquareFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = novaSquareFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = novaSquareFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = novaSquareFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = novaSquareFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = novaSquareFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = novaSquareFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = novaSquareFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = novaSquareFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = novaSquareFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = novaSquareFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = novaSquareFontFamily),
)
