package com.example.kinopoiskfake.view.main

import com.example.kinopoiskfake.model.FilmInfo

interface OnItemViewClickListener {
    fun onItemViewClick(filmInfo: FilmInfo)
}