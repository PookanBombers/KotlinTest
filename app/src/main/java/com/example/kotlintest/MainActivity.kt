package com.example.kotlintest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintest.databinding.ActivityMainBinding
import com.example.kotlintest.view.weatherlist.WeatherListFragment


lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance())
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
