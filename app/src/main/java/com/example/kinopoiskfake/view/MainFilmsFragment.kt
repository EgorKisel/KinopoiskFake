package com.example.kinopoiskfake.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kinopoiskfake.R
import com.example.kinopoiskfake.databinding.FragmentMainFilmsBinding
import com.example.kinopoiskfake.model.FilmInfo
import com.example.kinopoiskfake.viewmodel.AppState
import com.example.kinopoiskfake.viewmodel.MainViewModel

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
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val observer = object: Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)
            }
        }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilmInfo()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> binding.progressBarMain.visibility = View.GONE
            is AppState.Loading -> binding.progressBarMain.visibility = View.VISIBLE
            is AppState.Success -> {
                binding.progressBarMain.visibility = View.GONE
                setData(appState.filmData)
            }
        }
    }

    private fun setData(filmData: FilmInfo) {
        binding.nameFilm.text = filmData.film.name
        binding.genreFilm.text = filmData.film.genre
        binding.posterFilm.setImageResource(filmData.film.poster)
        binding.yearFilmInfo.text = filmData.film.year.toString()
        binding.durationFilm.text = filmData.film.getDurationFilmInString(filmData.film.duration)
        binding.annotationFilm.setText(filmData.filmAnnotation)
        binding.directorFilmName.text = filmData.director
        binding.actorsFilmInfo.text = filmData.actors
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFilmsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}