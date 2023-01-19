package com.enigmacamp.composecalculator.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enigmacamp.composecalculator.ui.components.CalcButton
import com.enigmacamp.composecalculator.ui.components.CalcResult
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
        modifier = Modifier.padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is UiState.Loading -> CalcResult(result = "Please wait")
            is UiState.Success -> CalcResult(result = uiState.data ?: "")
            is UiState.Error -> CalcResult(result = uiState.errorMessage ?: "")
            else -> CalcResult(result = stateResult.displayText)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column() {
                CalcButton(
                    label = "7",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "4",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "1",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
            }
            Column() {
                CalcButton(
                    label = "8",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "5",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "2",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "0",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
            }
            Column() {
                CalcButton(
                    label = "9",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "6",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
                CalcButton(
                    label = "3",
                    onClick = { onEvent(CalculatorEvent.NumberButtonClick(it)) })
            }
            Column() {
                CalcButton(
                    label = "C",
                    onClick = { onEvent(CalculatorEvent.OperatorButtonClick(it)) })
                CalcButton(
                    label = "+",
                    onClick = { onEvent(CalculatorEvent.OperatorButtonClick(it)) })
                CalcButton(
                    label = "-",
                    onClick = { onEvent(CalculatorEvent.OperatorButtonClick(it)) })
                CalcButton(
                    label = "=",
                    onClick = { onEvent(CalculatorEvent.OperatorButtonClick(it)) })
            }
        }

    }
}