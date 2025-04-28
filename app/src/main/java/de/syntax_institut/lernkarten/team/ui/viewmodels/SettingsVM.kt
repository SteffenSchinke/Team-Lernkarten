package de.syntax_institut.lernkarten.team.ui.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// simple singleton implementation for app settings
object SettingsVM {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    fun toggleThemeMode(newValue: Boolean) {

        _isDarkTheme.value = newValue
    }
}


