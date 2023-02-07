package com.example.kinopoiskfake.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kinopoiskfake.R
import com.example.kinopoiskfake.view.filminfo.MainFilmsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFilmsFragment.newInstance()).commit()
        }
    }
}