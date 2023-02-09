package com.example.kinopoiskfake.view.filminfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kinopoiskfake.databinding.FragmentMainFilmsBinding
import com.example.kinopoiskfake.model.FilmInfo

class MainFilmsFragment : Fragment() {

    private var _binding: FragmentMainFilmsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmInfo = arguments?.getParcelable<FilmInfo>(BUNDLE_EXTRA)

        filmInfo?.also {
            binding.nameFilm.text = it.film.name
            binding.genreFilm.text = it.film.genre
            binding.posterFilm.setImageResource(it.film.poster)
            binding.yearFilmInfo.text = it.film.year.toString()
            binding.durationFilm.text = it.film.getDurationFilmInString(it.film.duration)
            binding.annotationFilm.text = it.filmAnnotation.toString()
            binding.directorFilmName.text = it.director
            binding.actorsFilmInfo.text = it.actors
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "filmInfo"

        @JvmStatic
        fun newInstance(bundle: Bundle): MainFilmsFragment {
            val fragment = MainFilmsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}