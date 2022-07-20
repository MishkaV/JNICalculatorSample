package io.mishkav.jnicalculatorsample.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.mishkav.jnicalculatorsample.ui.screens.calculator.CalculatorScreen
import io.mishkav.jnicalculatorsample.ui.theme.JNICalculatorSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JNICalculatorSampleTheme {
                CalculatorScreen(
                    sum = { f, s -> sum(f, s) },
                    sub = { f, s -> sub(f, s) },
                    mult = { f, s -> mult(f, s) },
                    div = { f, s -> div(f, s) }
                )
            }
        }
    }

    external fun sum(first: Float, second: Float): Float
    external fun sub(first: Float, second: Float): Float
    external fun mult(first: Float, second: Float): Float
    external fun div(first: Float, second: Float): Float

    companion object {
        init {
            System.loadLibrary("cool-jni-lib")
        }
    }
}
