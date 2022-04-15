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
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.NumbersPanelContent
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.TopViewValues.inputText
import io.mishkav.jnicalculatorsample.ui.screens.calculator.entities.TopViewValues.result
import io.mishkav.jnicalculatorsample.ui.theme.Gray200

@Composable
fun CalculatorScreen(

) = Column(
    modifier = Modifier

        .background(Gray200)
        .fillMaxSize()
) {
    TopView()
    NumberPanel()
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
fun NumberPanel() {
    Box {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            NumbersPanelContent.numbers.forEach { numbers ->
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    numbers.forEach {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                                .clickable {
                                    inputText += it.content
                                    result += it.content
                                }

                        ) {
                            Text(
                                text = it.content,
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
                NumbersPanelContent.operations.forEach { sign ->
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
                                    // TODO
                                }
                        ) {
                            Text(
                                text = sign.content,
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

@Composable
@Preview
fun CalculatorScreenPreview() {
    CalculatorScreen()
}