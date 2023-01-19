package com.enigmacamp.composecalculator.service

interface CalculatorService {
    suspend fun sum(v1: String, v2: String): String
}