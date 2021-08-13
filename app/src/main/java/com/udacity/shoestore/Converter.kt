package com.udacity.shoestore

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("textToDecimal")
    @JvmStatic
    fun decimalToText(shoeSize: Double): String
    {
        return shoeSize.toString()
    }
    @JvmStatic
    fun textToDecimal(shoeSize: String): Double
    {
        return try {
            shoeSize.toDouble()
        } catch (ex: Exception) {
            0.0
        }
    }
}