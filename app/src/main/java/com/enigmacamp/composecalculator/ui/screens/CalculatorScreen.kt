package com.enigmacamp.composecalculator.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.enigmacamp.composecalculator.ui.components.CalcResult
import com.enigmacamp.composecalculator.ui.components.NumberInput
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enigmacamp.composecalculator.utilities.UiState

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel(factory = CalculatorViewModel.CalculatorViewModelFactory)) {
    val state = viewModel.calcState.collectAsState()
    Content(stateResult = state.value, viewModel::onEvent)
}

@Composable
fun Content(
    stateResult: CalculatorState,
    onEvent: (CalculatorEvent) -> Unit
) {
    Log.d("Recompose", "Content with state $stateResult")
    val uiState = stateResult.uiState
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is UiState.Loading -> CalcResult(result = "Please wait")
            is UiState.Success -> CalcResult(result = uiState.data ?: "")
            is UiState.Error -> CalcResult(result = uiState.errorMessage ?: "")
            else -> CalcResult(result = "")
        }
        NumberInput(
            label = "Number 1",
            placeholder = "Input your 1st number",
            numberVal = stateResult.angka1,
            onChange = { onEvent(CalculatorEvent.Number1Input(it)) }
        )
        NumberInput(
            label = "Number 2",
            placeholder = "Input your 2nd number",
            numberVal = stateResult.angka2,
            onChange = { onEvent(CalculatorEvent.Number2Input(it)) }
        )
    }
}