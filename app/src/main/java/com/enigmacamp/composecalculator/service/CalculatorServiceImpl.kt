package com.enigmacamp.composecalculator.service

import kotlinx.coroutines.delay

class CalculatorServiceImpl : CalculatorService {
    override suspend fun sum(v1: String, v2: String) = try {
        delay(5000L)
        (v1.toInt() + v2.toInt()).toString()
    } catch (e: NumberFormatException) {
        "Parsing error :("
    }
}