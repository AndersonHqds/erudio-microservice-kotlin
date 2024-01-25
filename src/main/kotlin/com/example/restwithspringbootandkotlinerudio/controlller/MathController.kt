package com.example.restwithspringbootandkotlinerudio.controlller

import com.example.restwithspringbootandkotlinerudio.converters.NumberConverter
import com.example.restwithspringbootandkotlinerudio.exceptions.UnsupportedMathOperationException
import com.example.restwithspringbootandkotlinerudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {
    val counter: AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath()
    @RequestMapping(value=["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please provide a numeric value")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please provide a numeric value")
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value="numberOne") numberOne: String?,
                       @PathVariable(value="numberTwo") numberTwo: String?): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please provide a numeric value")
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please provide a numeric value")
        if (numberTwo.equals("0")) throw UnsupportedMathOperationException("The divisor can not be 0")
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/avg/{numberOne}/{numberTwo}"])
    fun avg(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please provide a numeric value")
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value=["/sqrt/{numberOne}"])
    fun sqrt(@PathVariable(value="numberOne") numberOne: String?): Double {
        if (!NumberConverter.isNumeric(numberOne)) throw UnsupportedMathOperationException("Please provide a numeric value")
        return math.sqrt(NumberConverter.convertToDouble(numberOne))
    }
}