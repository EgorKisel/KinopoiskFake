package com.example.kinopoiskfake.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kinopoiskfake.R

class MainFilmsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_films, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFilmsFragment()
    }
}