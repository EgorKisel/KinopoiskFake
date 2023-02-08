package com.example.kinopoiskfake.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kinopoiskfake.R
import com.example.kinopoiskfake.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance()).commit()
        }
    }
}