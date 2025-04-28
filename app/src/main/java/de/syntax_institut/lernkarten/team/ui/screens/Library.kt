package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Library(

            modifier: Modifier = Modifier
) {

    Surface(

        modifier = modifier
    ) {


    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LibraryPreview() {

    Library()
}