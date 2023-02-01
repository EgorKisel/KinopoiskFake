package com.example.kinopoiskfake.model

import com.example.kinopoiskfake.R

data class FilmInfo(
    val film: Film = getDefaultFilm(),
    val filmAnnotation: Int = R.string.puss_in_boots_annotation,
    val director: String = "Joel Crawford, Hanuel Mercado",
    val actors: String = "Antonio Banderas, Salma Hayek, Harvey Guillen, Florence Pugh, John Mulaney, Wagner Moura, Ray Winston, Samson Kayo, Olivia Colman, Davine Joy Randolph"
)

fun getDefaultFilm() = Film(
    R.drawable.puss_in_boots2,
    "Puss in Boots: The Last Wish",
    "cartoon, comedy, adventure, fantasy",
    102,
    2022
)

data class Film(
    val poster: Int,
    val name: String,
    val genre: String,
    val duration: Int,
    val year: Int
) {
    fun getDurationFilmInString(duration: Int): String {
        val hours: Int = duration / 60
        val minutes: Int = duration - 60 * hours
        return "$hours h. $minutes min."
    }
}
