package com.example.kinopoiskfake.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoiskfake.R
import com.example.kinopoiskfake.databinding.MainFragmentBinding
import com.example.kinopoiskfake.model.FilmInfo
import com.example.kinopoiskfake.view.filminfo.MainFilmsFragment
import com.example.kinopoiskfake.view.filminfo.MainFilmsFragment.Companion.BUNDLE_EXTRA
import com.example.kinopoiskfake.viewmodel.AppState
import com.example.kinopoiskfake.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(), OnItemViewClickListener {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapterHits = MainFragmentAdapterHits(this)
    private val adapterNovelties = MainFragmentAdapterHits(this)

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hitsRecyclerMainFragment.also {
            it.adapter = adapterHits
            it.layoutManager = LinearLayoutManager(it.context,
                LinearLayoutManager.HORIZONTAL, false)
            it.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }

        binding.noveltiesRecyclerMainFragment.also {
            it.adapter = adapterNovelties
            it.layoutManager = LinearLayoutManager(it.context,
                LinearLayoutManager.HORIZONTAL, false)
            it.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }

        val observer = Observer<AppState> { data -> renderData(data) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilmInfo()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.root, "Error", Snackbar.LENGTH_LONG)
                    .setAction("Try again") {viewModel.getFilmInfo()}.show()
            }
            is AppState.Loading -> binding.loadingLayout.visibility = View.VISIBLE
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                adapterHits.setFilmInfo(appState.filmDataHits)
                adapterNovelties.setFilmInfo(appState.filmDataNovelties)
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemViewClick(filmInfo: FilmInfo) {
        val bundle = Bundle()
        bundle.putParcelable(BUNDLE_EXTRA, filmInfo)
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFilmsFragment.newInstance(bundle)).addToBackStack("").commit()
    }
}