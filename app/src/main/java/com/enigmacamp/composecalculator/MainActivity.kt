package com.enigmacamp.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enigmacamp.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result: 0")
        TextField("0",
            onValueChange = {},
            label = { Text(text = "Angka 1") },
            placeholder = {
                Text(text = "Masukan angka 1")
            })
        TextField("0",
            onValueChange = {},
            label = { Text(text = "Angka 2") },
            placeholder = {
                Text(text = "Masukan angka 2")
            })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        Calculator()
    }
}