package com.enigmacamp.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CalculatorState {
    var stateAngka1 by mutableStateOf("")
    var stateAngka2 by mutableStateOf("")
    val stateResult
        get() = sum(stateAngka1, stateAngka2)

    fun sum(v1: String, v2: String) = try {
        (v1.toInt() + v2.toInt()).toString()
    } catch (e: NumberFormatException) {
        "Parsing error :("
    }
}