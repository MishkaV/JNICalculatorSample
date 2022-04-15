package io.mishkav.jnicalculatorsample.ui.screens.calculator.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed class Button(
    val content: String = ""
)

class DigitButton(digit: String) : Button(content = digit)
class SignButton(sign: String) : Button(content = sign)

@Composable
fun ButtonView(
    content: String
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.size(40.dp)
) {
    Text(
        text = content,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.wrapContentHeight()
    )
}