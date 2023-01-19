package com.enigmacamp.composecalculator.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewModelScope
import com.enigmacamp.composecalculator.service.CalculatorService
import com.enigmacamp.composecalculator.service.CalculatorServiceImpl
import kotlinx.coroutines.flow.*

class CalculatorViewModel(val service: CalculatorService) : ViewModel() {
    private var _stateAngka1 = MutableStateFlow("")
    val stateAngka1 = _stateAngka1.asStateFlow()

    private var _stateAngka2 = MutableStateFlow("")
    val stateAngka2 = _stateAngka2.asStateFlow()

    val stateResult = combine(_stateAngka1, _stateAngka2) { a, b ->
        service.sum(a, b)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "0")


    fun onChangeAngka1(value: String) {
        _stateAngka1.value = value
    }

    fun onChangeAngka2(value: String) {
        _stateAngka2.value = value
    }

    companion object CalculatorViewModelFactory : Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CalculatorViewModel(CalculatorServiceImpl()) as T
        }
    }

}