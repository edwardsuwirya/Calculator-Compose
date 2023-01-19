package com.enigmacamp.composecalculator.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CalcResult(result: String) {
    Text(text = "Result: $result")
}