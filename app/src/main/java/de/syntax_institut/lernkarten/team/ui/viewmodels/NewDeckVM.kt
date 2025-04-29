package de.syntax_institut.lernkarten.team.ui.viewmodels
import androidx.compose.ui.graphics.Color
import de.syntax_institut.lernkarten.team.ui.data.Flashcard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object NewDeckVM {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    private val _question = MutableStateFlow("")
    val question: StateFlow<String> = _question.asStateFlow()

    private val _answer = MutableStateFlow("")
    val answer: StateFlow<String> = _answer.asStateFlow()

    private val _color = MutableStateFlow(Color.Red)
    val color: StateFlow<Color> = _color.asStateFlow()

    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards.asStateFlow()

    fun titleValueChanged(newValue: String) {

        _title.value = newValue
    }

    fun questionValueChanged(newValue: String) {

        _question.value = newValue
    }

    fun answerValueChanged(newValue: String) {

        _answer.value = newValue
    }

    fun colorValueChanged(newValue: Color) {

        _color.value = newValue
    }

    fun addCard() {

        val listCount = _flashcards.value.count()
        val newCard = Flashcard(
            id = (listCount + 1).toLong(),
            question = _question.value,
            answer = _answer.value
        )

        _flashcards.value += newCard
        _question.value = ""
        _answer.value = ""
    }
}