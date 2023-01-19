package com.enigmacamp.composecalculator.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberInput(label: String, placeholder: String, numberVal: String, onChange: (String) -> Unit) {
    TextField(numberVal,
        onValueChange = { onChange(it) },
        label = { Text(text = label) },
        placeholder = {
            Text(text = placeholder)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}