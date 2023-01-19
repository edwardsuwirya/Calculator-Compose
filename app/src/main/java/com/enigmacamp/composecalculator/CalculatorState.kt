package com.enigmacamp.composecalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class CalculatorState {
    private var _stateAngka1 = MutableStateFlow("")
    val stateAngka1 = _stateAngka1.asStateFlow()

    private var _stateAngka2 = MutableStateFlow("")
    val stateAngka2 = _stateAngka2.asStateFlow()

    val stateResult = combine(_stateAngka1, _stateAngka2) { a, b ->
        sum(a, b)
    }.stateIn(CoroutineScope(Dispatchers.Main), WhileSubscribed(), "0")


    fun onChangeAngka1(value: String) {
        _stateAngka1.value = value
    }

    fun onChangeAngka2(value: String) {
        _stateAngka2.value = value
    }

    private fun sum(v1: String, v2: String) = try {
        (v1.toInt() + v2.toInt()).toString()
    } catch (e: NumberFormatException) {
        "Parsing error :("
    }
}