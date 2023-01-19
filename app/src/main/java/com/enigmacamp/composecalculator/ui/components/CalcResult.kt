package com.enigmacamp.composecalculator.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CalcResult(result: String) {
    Row(
        modifier = Modifier
            .border(BorderStroke(2.dp, Color.Red))
            .padding(16.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Result")
        Text(text = result)
    }
}