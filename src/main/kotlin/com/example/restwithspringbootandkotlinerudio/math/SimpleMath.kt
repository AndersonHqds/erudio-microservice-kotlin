package com.example.restwithspringbootandkotlinerudio.math

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun subtraction(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun multiplication(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo

    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2

    fun sqrt(numberOne: Double) = kotlin.math.sqrt(numberOne)
}