package com.learn.restspringbootkotlin.controller

import com.learn.restspringbootkotlin.exceptions.UnsupportedMathOperationException
import com.learn.restspringbootkotlin.service.MathService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/math"])
class MathController {

    private var mathService = MathService()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.sum(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.subtract(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.multiplication(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.division(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value = "numberOne") numberOne: String?,
                   @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.average(numberOne, numberTwo)
    }
    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value = "number") number: String?): Double {

        if(!mathService.isNumeric(number)) {
            throw UnsupportedMathOperationException("All Entries Must Be Numeric")
        }

        return mathService.squareRoot(number)
    }


}