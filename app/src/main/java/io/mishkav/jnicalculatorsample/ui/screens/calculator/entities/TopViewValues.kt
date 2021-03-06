package io.mishkav.jnicalculatorsample.ui.screens.calculator.entities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.DeleteButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.DigitButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.EmptyButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.SignButton

object TopViewValues {
    var inputText by mutableStateOf("")
    var result by mutableStateOf("")
}

object MathState {
    var bufferPrev by mutableStateOf("")
    var bufferNext by mutableStateOf("")
    var wasSign by mutableStateOf("")
}

object NumbersPanelContent {
    var numbers = listOf(
        listOf(
            DigitButton("7"),
            DigitButton("4"),
            DigitButton("1"),
            SignButton(".")
        ),
        listOf(
            DigitButton("8"),
            DigitButton("5"),
            DigitButton("2"),
            DigitButton("0")
        ),
        listOf(
            DigitButton("9"),
            DigitButton("6"),
            DigitButton("3"),
            EmptyButton()
        )
    )
    var operations = listOf(
        DeleteButton(),
        SignButton("+"),
        SignButton("-"),
        SignButton("/"),
        SignButton("*")
    )
}