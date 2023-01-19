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

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel(factory = CalculatorViewModel.CalculatorViewModelFactory)) {
    Log.d("Recompose", "True")
    val stateAngka1 = viewModel.stateAngka1.collectAsState()
    val stateAngka2 = viewModel.stateAngka2.collectAsState()
    val stateResult = viewModel.stateResult.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalcResult(result = stateResult.value)
        NumberInput(
            label = "Number 1",
            placeholder = "Input your 1st number",
            numberVal = stateAngka1.value,
            onChange = viewModel::onChangeAngka1
        )
        NumberInput(
            label = "Number 2",
            placeholder = "Input your 2nd number",
            numberVal = stateAngka2.value,
            onChange = viewModel::onChangeAngka2
        )
    }
}