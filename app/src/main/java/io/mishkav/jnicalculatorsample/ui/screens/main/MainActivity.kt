package io.mishkav.jnicalculatorsample.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.mishkav.jnicalculatorsample.ui.screens.calculator.CalculatorScreen
import io.mishkav.jnicalculatorsample.ui.theme.JNICalculatorSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JNICalculatorSampleTheme {
                CalculatorScreen()
            }
        }
    }
}
