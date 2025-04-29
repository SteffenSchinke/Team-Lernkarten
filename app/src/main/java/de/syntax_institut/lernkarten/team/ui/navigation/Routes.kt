package de.syntax_institut.lernkarten.team.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object LibraryRoute

@Serializable
object SettingsRoute

@Serializable
object NewDeckRoute

@Serializable
object AppLauncherRoute

@Serializable
class FlashcardRoute(val deckId: Long = 0L)