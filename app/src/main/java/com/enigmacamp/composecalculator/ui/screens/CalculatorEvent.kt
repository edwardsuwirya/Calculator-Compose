package com.enigmacamp.composecalculator.ui.screens

sealed class CalculatorEvent {
    class Number1Input(val num: String) : CalculatorEvent()
    class Number2Input(val num: String) : CalculatorEvent()
}
