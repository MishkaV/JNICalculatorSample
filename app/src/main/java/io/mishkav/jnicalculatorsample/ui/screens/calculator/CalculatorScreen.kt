package io.mishkav.jnicalculatorsample.ui.screens.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.DeleteButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.DigitButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.components.SignButton
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.MathState.bufferNext
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.MathState.bufferPrev
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.MathState.wasSign
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.NumbersPanelContent
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.TopViewValues.inputText
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.TopViewValues.result
import io.mishkav.jnicalculatorsample.ui.theme.Gray200

@Composable
fun CalculatorScreen(
    sum: (first: Float, second: Float) -> Float = { _, _ -> 0F },
    sub: (first: Float, second: Float) -> Float = { _, _ -> 0F },
    mult: (first: Float, second: Float) -> Float = { _, _ -> 0F },
    div: (first: Float, second: Float) -> Float = { _, _ -> 0F }
) = Column(
    modifier = Modifier
        .background(Gray200)
        .fillMaxSize()
) {
    TopView()
    NumberPanel(sum, sub, mult, div)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopView() {
    Card(
        shape = RoundedCornerShape(
            bottomStart = 30.dp,
            bottomEnd = 30.dp
        ),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 32.dp
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = inputText,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.End),
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = result,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.End),
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                maxLines = 1
            )
        }
    }
}

@Composable
fun NumberPanel(
    sum: (first: Float, second: Float) -> Float,
    sub: (first: Float, second: Float) -> Float,
    mult: (first: Float, second: Float) -> Float,
    div: (first: Float, second: Float) -> Float
) {
    Box {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            NumbersPanelContent.numbers.forEach { numbers ->
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    numbers.forEach { button ->
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                                .clickable {
                                    // Hello solid
                                    when (button) {
                                        is DigitButton -> {
                                            inputText += button.content

                                            if (wasSign.isNotEmpty()) {
                                                bufferNext += button.content
                                                result = calculate(sum, sub, mult, div)
                                            } else {
                                                result += button.content
                                            }
                                        }
                                        is SignButton -> {
                                            inputText += button.content
                                            result += button.content
                                        }
                                    }
                                }

                        ) {
                            Text(
                                text = button.content,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.wrapContentSize()
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.weight(1.3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NumbersPanelContent.operations.forEach { operation ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            modifier = Modifier
                                .size(80.dp)
                                .clickable {
                                    when (operation) {
                                        is DeleteButton -> {
                                            inputText = ""
                                            result = ""
                                            bufferNext = ""
                                            bufferPrev = ""
                                            wasSign = ""
                                        }
                                        else -> {
                                            if (wasSign.isNotEmpty()) {
                                                bufferPrev = calculate(sum, sub, mult, div)
                                                wasSign = operation.content
                                                bufferNext = ""
                                            } else {
                                                bufferPrev = inputText
                                                wasSign = operation.content
                                            }
                                            inputText += operation.content
                                            result += operation.content
                                        }
                                    }
                                }
                        ) {
                            Text(
                                text = operation.content,
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.wrapContentSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

// Hello solid again
private fun calculate(
    sum: (first: Float, second: Float) -> Float,
    sub: (first: Float, second: Float) -> Float,
    mult: (first: Float, second: Float) -> Float,
    div: (first: Float, second: Float) -> Float
) = when (wasSign) {
    "+" -> sum(bufferPrev.toFloat(), bufferNext.toFloat())
    "-" -> sub(bufferPrev.toFloat(), bufferNext.toFloat())
    "*" -> mult(bufferPrev.toFloat(), bufferNext.toFloat())
    else -> div(bufferPrev.toFloat(), bufferNext.toFloat())
}.toString()

@Composable
@Preview
fun CalculatorScreenPreview() {
    CalculatorScreen()
}