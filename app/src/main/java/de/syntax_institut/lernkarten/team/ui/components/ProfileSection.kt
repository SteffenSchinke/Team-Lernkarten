package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Profilbild (hier mit Platzhalter)
        Image(
            painter = painterResource(id = android.R.drawable.sym_def_app_icon),
            contentDescription = "Profilbild",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Name
        Text(
            text = "Max Mustermann",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Username
        Text(
            text = "@maxmustermann",
            fontSize = 16.sp
        )
    }
}