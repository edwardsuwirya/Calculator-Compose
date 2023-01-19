package com.enigmacamp.composecalculator.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewModelScope
import com.enigmacamp.composecalculator.service.CalculatorService
import com.enigmacamp.composecalculator.service.CalculatorServiceImpl
import com.enigmacamp.composecalculator.utilities.UiState
import com.enigmacamp.composecalculator.utilities.toIntSafety
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel(val service: CalculatorService) : ViewModel() {
    private var _calcState = MutableStateFlow(CalculatorState())
    val calcState = _calcState.asStateFlow()

    fun onEvent(event: CalculatorEvent) {
        Log.d("Recompose", "Content Change")
        when (event) {
            is CalculatorEvent.NumberButtonClick -> {
                val stringNum = "${_calcState.value.displayText}${event.num}"
                if (_calcState.value.opr == null) {
                    _calcState.value =
                        _calcState.value.copy(
                            num1 = stringNum,
                            displayText = stringNum.toIntSafety().toString()
                        )
                } else {
                    _calcState.value =
                        _calcState.value.copy(
                            num2 = stringNum,
                            displayText = stringNum
                        )
                }

            }

            is CalculatorEvent.OperatorButtonClick -> {
                when (event.opr) {
                    "=" -> {
                        if (_calcState.value.num1.isNotEmpty() && _calcState.value.num2.isNotEmpty()) {
                            viewModelScope.launch {
                                _calcState.value = _calcState.value.copy(uiState = UiState.Loading)
                                val result =
                                    service.sum(_calcState.value.num1, _calcState.value.num2)
                                _calcState.value =
                                    _calcState.value.copy(uiState = result)
                            }
                        }
                    }
                    "C" -> {
                        _calcState.value =
                            CalculatorState()
                    }
                    else -> {
                        if (_calcState.value.num1.isNotEmpty() && _calcState.value.num2.isEmpty()) {
                            _calcState.value =
                                _calcState.value.copy(displayText = "", opr = event.opr)
                        }
                    }
                }

            }
        }
    }

    companion object CalculatorViewModelFactory : Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CalculatorViewModel(CalculatorServiceImpl()) as T
        }
    }

}