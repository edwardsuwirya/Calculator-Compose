package com.enigmacamp.composecalculator.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewModelScope
import com.enigmacamp.composecalculator.service.CalculatorService
import com.enigmacamp.composecalculator.service.CalculatorServiceImpl
import com.enigmacamp.composecalculator.utilities.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class CalculatorViewModel(val service: CalculatorService) : ViewModel() {
    private var _calcState = MutableStateFlow(CalculatorState())
    val calcState = _calcState.asStateFlow().transform { res ->
        Log.d("Recompose", "Calc")
        emit(res.copy(uiState = UiState.Loading))
        val result = service.sum(res.angka1, res.angka2)
        emit(res.copy(uiState = result))
    }
        .flowOn(Dispatchers.IO)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), CalculatorState())


    fun onEvent(event: CalculatorEvent) {
        Log.d("Recompose", "Content Change")
        when (event) {
            is CalculatorEvent.Number1Input -> _calcState.value =
                _calcState.value.copy(angka1 = event.num)

            is CalculatorEvent.Number2Input -> _calcState.value =
                _calcState.value.copy(angka2 = event.num)
        }
    }

    companion object CalculatorViewModelFactory : Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CalculatorViewModel(CalculatorServiceImpl()) as T
        }
    }

}