package com.example.kinopoiskfake.model

interface Repository {
    fun getFilmsFromServer(): FilmInfo
    fun getFilmsFromLocalStorage(): FilmInfo
}