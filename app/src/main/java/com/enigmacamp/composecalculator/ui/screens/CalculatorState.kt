package com.enigmacamp.composecalculator.ui.screens

import com.enigmacamp.composecalculator.utilities.UiState

data class CalculatorState(
    val uiState: UiState<String>? = null,
    val angka1: String = "",
    val angka2: String = "",
)