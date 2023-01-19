package com.enigmacamp.composecalculator.usecases

import com.enigmacamp.composecalculator.utilities.UiState

fun interface AddNumberUseCase : suspend (String, String) -> UiState<String>