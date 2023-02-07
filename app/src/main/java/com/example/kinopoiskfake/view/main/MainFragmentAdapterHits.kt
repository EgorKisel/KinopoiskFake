package com.example.kinopoiskfake.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoiskfake.databinding.RecyclerFilmHolderBinding
import com.example.kinopoiskfake.model.FilmInfo

class MainFragmentAdapterHits(private val onItemViewClickListener: OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapterHits.MainFragmentFilmHolder>() {

    private var filmData: List<FilmInfo> = listOf()

    fun setFilmInfo(data: List<FilmInfo>) {
        this.filmData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentFilmHolder {
        val binding =
            RecyclerFilmHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainFragmentFilmHolder(binding.root)
    }

    override fun onBindViewHolder(
        holder: MainFragmentAdapterHits.MainFragmentFilmHolder,
        position: Int
    ) = holder.bind(filmData[position])


    override fun getItemCount() = filmData.size

    inner class MainFragmentFilmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(filmInfo: FilmInfo) {
            val binding = RecyclerFilmHolderBinding.bind(itemView)
            binding.posterRecyclerFilmHolder.setImageResource(filmInfo.film.poster)
            binding.nameRecyclerFilmHolder.text = filmInfo.film.name
            binding.genreRecyclerFilmHolder.text = filmInfo.film.genre
            binding.yearRecyclerFilmHolder.text = filmInfo.film.year.toString()
            binding.root.setOnClickListener {
                onItemViewClickListener.onItemViewClick(filmInfo)
            }
        }
    }
}