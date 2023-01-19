package com.enigmacamp.composecalculator.service

import com.enigmacamp.composecalculator.utilities.UiState
import com.enigmacamp.composecalculator.utilities.toIntSafety
import kotlinx.coroutines.delay

class CalculatorServiceImpl : CalculatorService {
    override suspend fun sum(v1: String, v2: String): UiState<String> {
        delay(3000L)
        return UiState.Success((v1.toIntSafety() + v2.toIntSafety()).toString())
    }

}