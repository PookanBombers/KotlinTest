package com.example.kotlintest

import android.util.Log

class TestTest {
   private lateinit var number1: String
   private lateinit var number2: String

    fun name() {
        number1 = ("вывод через функцию")
        number2 = (40).toString()
        Log.d("@@@", number1)
        Log.d("@@@", number2)
    }
}