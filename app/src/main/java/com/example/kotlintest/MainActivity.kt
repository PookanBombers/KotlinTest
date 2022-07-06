package com.example.kotlintest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.kotlintest.R
import kotlin.math.log




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

            }

        })

        val cat = object {
            val name = "Barsik"
        }

        //var - изменяемая
        //val - не изменяемая

        val test: Test = Test(4,8)
        val test2 = Test (6, 10)

        val testTest:TestTest = TestTest()
        testTest.name()

        val test3 = test.num1
        test.num2 = test3

        Log.d("@@@", test3.toString())

        val noteTest: NoteTest = NoteTest(50,200)

        Log.d("@@@", noteTest.speed.toString())
        Log.d("@@@", noteTest.distance.toString())

        val dataClass1 = NoteTest(50,200)
        val dataClass2 = dataClass1.copy(30,150)

        Log.d("@@@", dataClass2.toString())

    }
}