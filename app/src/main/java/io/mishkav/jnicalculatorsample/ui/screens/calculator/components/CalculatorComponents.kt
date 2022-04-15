package io.mishkav.jnicalculatorsample.ui.screens.calculator.components

sealed class Button(
    val content: String = ""
)

class DigitButton(digit: String) : Button(content = digit)
class DeleteButton : Button(content = "del")
class SignButton(sign: String) : Button(content = sign)
