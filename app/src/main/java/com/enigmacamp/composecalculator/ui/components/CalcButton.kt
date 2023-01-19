package com.enigmacamp.composecalculator.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CalcButton(label: String, onClick: (String) -> Unit) {
    Button(onClick = { onClick(label) }) {
        Text(text = label)
    }
}