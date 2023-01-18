package com.enigmacamp.composecalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.enigmacamp.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
//                    CalculatorClassState(CalculatorState())
                    CalculatorLocalState()
                }
            }
        }
    }
}

@Composable
fun CalculatorClassState(state: CalculatorState) {
    // Try to rotate the device
    Log.d("Recompose", "True")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result: ${state.stateResult}")
        TextField(
            state.stateAngka1,
            onValueChange = { state.stateAngka1 = it },
            label = { Text(text = "Angka 1") },
            placeholder = {
                Text(text = "Masukan angka 1")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state.stateAngka2,
            onValueChange = { state.stateAngka2 = it },
            label = { Text(text = "Angka 2") },
            placeholder = {
                Text(text = "Masukan angka 2")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun CalculatorLocalState() {
    // Try to rotate the device
//    var stateAngka1 by remember {
//        mutableStateOf("")
//    }
//    var stateAngka2 by remember {
//        mutableStateOf("")
//    }
//
//    val stateResult = sum(stateAngka1, stateAngka2)
    val state = remember {
        CalculatorState()
    }

    Log.d("Recompose", "True")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result: ${state.stateResult}")
        TextField(
            state.stateAngka1,
            onValueChange = { state.stateAngka1 = it },
            label = { Text(text = "Angka 1") },
            placeholder = {
                Text(text = "Masukan angka 1")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state.stateAngka2,
            onValueChange = { state.stateAngka2 = it },
            label = { Text(text = "Angka 2") },
            placeholder = {
                Text(text = "Masukan angka 2")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

fun sum(v1: String, v2: String) = try {
    (v1.toInt() + v2.toInt()).toString()
} catch (e: NumberFormatException) {
    "Parsing error :("
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        CalculatorClassState(CalculatorState())
    }
}