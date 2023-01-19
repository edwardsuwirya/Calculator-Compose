package com.enigmacamp.composecalculator.utilities

fun String.toIntSafety(): Int {
    return try {
        this.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}