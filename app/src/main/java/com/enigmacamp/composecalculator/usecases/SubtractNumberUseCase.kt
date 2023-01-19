package com.enigmacamp.composecalculator.usecases

import com.enigmacamp.composecalculator.utilities.UiState

fun interface SubtractNumberUseCase : suspend (String, String) -> UiState<String>