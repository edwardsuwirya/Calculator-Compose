package com.enigmacamp.composecalculator.utilities

sealed class UiState<out T : Any> {
    data class Success<out T : Any>(val data: T?) : UiState<T>()
    object Loading : UiState<Nothing>()
    class Error(val errorMessage: String?) : UiState<Nothing>()
}