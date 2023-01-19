package com.enigmacamp.composecalculator.ui.screens

import com.enigmacamp.composecalculator.utilities.UiState

data class CalculatorState(
    val uiState: UiState<String>? = null,
    val displayText: String = "",
    val num1: String = "",
    val num2: String = "",
    val opr: String? = null,
)