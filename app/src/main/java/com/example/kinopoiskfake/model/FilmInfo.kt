package com.example.kinopoiskfake.model

import android.os.Parcelable
import com.example.kinopoiskfake.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmInfo(
    val film: Film = getDefaultFilm(),
    val filmAnnotation: Int = R.string.puss_in_boots_annotation,
    val director: String = "Joel Crawford, Hanuel Mercado",
    val actors: String = "Antonio Banderas, Salma Hayek, Harvey Guillen, Florence Pugh, John Mulaney, Wagner Moura, Ray Winston, Samson Kayo, Olivia Colman, Davine Joy Randolph"
) : Parcelable

fun getDefaultFilm() = Film(
    R.drawable.puss_in_boots2,
    "Puss in Boots: The Last Wish",
    "cartoon, comedy, adventure, fantasy",
    102,
    2022
)

fun getNoveltiesFilms() = listOf(
    FilmInfo(Film(R.drawable.Cinderella, "Cinderella", "fantasy, drama", 105, 2015)),
    FilmInfo(Film(R.drawable.Downton_Abbey,"Downton Abbey", "drama, melodrama", 122, 2019)),
    FilmInfo(Film(R.drawable.Generation_П, "Generation П", "fantasy, drama, comedy", 120, 2011)),
    FilmInfo(Film(R.drawable.Hummingbird, "Hummingbird","thriller, drama, crime, action", 100, 2012)),
    FilmInfo(Film(R.drawable.Nobody, "Nobody", "action, thriller, crime", 92, 2021))
)

fun getHitsFilms() = listOf(
    FilmInfo(Film(R.drawable.Quo_vado, "Quo vado?","comedy", 86, 2015)),
    FilmInfo(Film(R.drawable.She_is_the_Man, "She's the Man", "melodrama, comedy, sports", 105, 2005)),
    FilmInfo(Film(R.drawable.The_Father, "The Father","drama", 97, 2020)),
    FilmInfo(Film(R.drawable.Widows, "Widows","thriller, drama, crime", 129, 2018)),
    FilmInfo(Film(R.drawable.The_Physician, "The_Physician","adventure, history, drama", 155, 2013))
)

@Parcelize
data class Film(
    val poster: Int,
    val name: String,
    val genre: String,
    val duration: Int,
    val year: Int
) : Parcelable {
    fun getDurationFilmInString(duration: Int): String {
        val hours: Int = duration / 60
        val minutes: Int = duration - 60 * hours
        return "$hours h. $minutes min."
    }
}
