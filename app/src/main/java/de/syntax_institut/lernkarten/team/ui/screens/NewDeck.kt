package de.syntax_institut.lernkarten.team.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.syntax_institut.lernkarten.team.ui.extension.toHex
import de.syntax_institut.lernkarten.team.ui.components.ColorPicker
import de.syntax_institut.lernkarten.team.ui.components.FlashcardItem
import de.syntax_institut.lernkarten.team.ui.viewmodels.NewDeckVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewDeck(

    modifier: Modifier = Modifier
) {

    Surface(

        modifier = modifier.padding(16.dp)
    ) {


        val title by NewDeckVM.title.collectAsState()
        val question by NewDeckVM.question.collectAsState()
        val answer by NewDeckVM.answer.collectAsState()
        val color by NewDeckVM.color.collectAsState()
        val flashcards by NewDeckVM.flashcards.collectAsState()

        var showColorSheet by remember { mutableStateOf(false) }
        val colorSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )


        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(color = color)
            ) {

                Row {

                    TextField(
                        title,
                        label = { Text("Titel") },
                        onValueChange = NewDeckVM::titleValueChanged,
                        modifier = Modifier
                            .fillMaxWidth(fraction = 0.85f)
                            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    )

                    Spacer(Modifier.weight(1f))

                    IconButton(
                        onClick = { showColorSheet = true },
                        modifier = Modifier
                            .padding(top = 26.dp, end = 24.dp)
                            .scale(2f),
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ColorLens,
                            contentDescription = "Color Picker",
                            tint = Color(
                                red = 1f - color.red,
                                green = 1f - color.green,
                                blue = 1f - color.blue,
                                alpha = color.alpha
                            )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .border(
                        width = 5.dp,
                        color = color,
                        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                    )
            ) {

                Column {

                    TextField(
                        question,
                        label = { Text("Frage") },
                        onValueChange = NewDeckVM::questionValueChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )

                    TextField(
                        answer,
                        label = { Text("Antwort") },
                        onValueChange = NewDeckVM::answerValueChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        minLines = 4,
                        maxLines = 4,
                        singleLine = false
                    )

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Spacer(Modifier.weight(1f))

                        IconButton(
                            onClick = NewDeckVM::addCard,
                            modifier = Modifier
                                .padding(end = 16.dp, bottom = 16.dp)
                                .scale(2f),
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Save,
                                contentDescription = "Color Picker",
                                tint = color
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(flashcards) { flashcard ->
                    FlashcardItem(
                        flashcard = flashcard,
                        deckColor = color.toHex()
                    )
                }
            }
        }

        if (showColorSheet) {

            ModalBottomSheet(
                onDismissRequest = { showColorSheet = false },
                sheetState = colorSheetState
            ) {

                ColorPicker(
                    selectedColor = color,
                    onColorChanged = { NewDeckVM.colorValueChanged(it) },
                    onDismiss = { showColorSheet = false }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewDeckPreview() {

    NewDeck()
}