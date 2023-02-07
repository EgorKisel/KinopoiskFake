package com.example.kinopoiskfake.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kinopoiskfake.R
import com.example.kinopoiskfake.databinding.MainFragmentBinding
import com.example.kinopoiskfake.model.FilmInfo
import com.example.kinopoiskfake.view.filminfo.MainFilmsFragment
import com.example.kinopoiskfake.view.filminfo.MainFilmsFragment.Companion.BUNDLE_EXTRA
import com.example.kinopoiskfake.viewmodel.MainViewModel

class MainFragment : Fragment(), OnItemViewClickListener {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

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