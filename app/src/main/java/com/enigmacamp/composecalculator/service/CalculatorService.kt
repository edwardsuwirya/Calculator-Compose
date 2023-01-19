package com.enigmacamp.composecalculator.service

import com.enigmacamp.composecalculator.utilities.UiState

interface CalculatorService {
    suspend fun sum(v1: String, v2: String): UiState<String>
    suspend fun subtract(v1: String, v2: String): UiState<String>
}