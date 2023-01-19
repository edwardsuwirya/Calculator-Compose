package com.enigmacamp.composecalculator.ui.screens

sealed class CalculatorEvent {
    class NumberButtonClick(val num: String) : CalculatorEvent()
    class OperatorButtonClick(val opr: String) : CalculatorEvent()
}
