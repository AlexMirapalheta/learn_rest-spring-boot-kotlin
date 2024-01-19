package com.learn.restspringbootkotlin.service

import com.learn.restspringbootkotlin.exceptions.UnsupportedMathOperationException
import org.springframework.stereotype.Service
import kotlin.math.sqrt

@Service
class MathService {

    fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        val result = number.matches(regex = """[-+]?[0-9]*\.?[0-9]+""".toRegex())

        return result
    }

    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")

        return if (isNumeric(strNumber)) {
            number.toDouble()
        } else {
            throw UnsupportedMathOperationException("Fail to Convert String to Double")
        }
    }
    fun sum (numberOne: String?, numberTwo: String?): Double {
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    fun subtract (numberOne: String?, numberTwo: String?): Double {
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    fun multiplication (numberOne: String?, numberTwo: String?): Double {
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    fun division (numberOne: String?, numberTwo: String?): Double {
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    fun average (numberOne: String?, numberTwo: String?): Double {
        return sum(numberOne, numberTwo) / 2
    }

    fun squareRoot (number: String?): Double {
        return sqrt(convertToDouble(number))
    }


}