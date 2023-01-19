package com.enigmacamp.composecalculator.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class CalculatorViewModel : ViewModel() {
    private var _stateAngka1 = MutableStateFlow("")
    val stateAngka1 = _stateAngka1.asStateFlow()

    private var _stateAngka2 = MutableStateFlow("")
    val stateAngka2 = _stateAngka2.asStateFlow()

    val stateResult = combine(_stateAngka1, _stateAngka2) { a, b ->
        sum(a, b)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "0")


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