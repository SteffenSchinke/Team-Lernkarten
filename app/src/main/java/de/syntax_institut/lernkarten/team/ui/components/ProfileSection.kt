package de.syntax_institut.lernkarten.team.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
     Icon(Icons.Default.Person,"Person",
         Modifier.size(32.dp))




        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Max Mustermann", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "@maxmustermann", fontSize = 16.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileSectionView() {
    ProfileSection()
}