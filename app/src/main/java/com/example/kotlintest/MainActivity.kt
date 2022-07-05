package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test: Test = Test(4,8)
    }
}