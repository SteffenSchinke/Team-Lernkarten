package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingItem(
    name: String,
    value: String? = null,
    onClick: (() -> Unit)? = null,
    action: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(text = name, fontSize = 16.sp)

        if (value != null) {
            Text(
                text = value,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp))
        }

        action?.invoke()
    }

    if (onClick != null) {
        Modifier.clickable { onClick() }
    }
}