package com.example.moviesretrofit

import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesretrofit.databinding.MovieItemBinding

class MoviesAdapter(val context: Context): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


   inner class MoviesViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
       fun bind(movie: Result) {
           binding.apply {
               Glide.with(context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(moviePhoto)
               movieTitle.text = context.getString(R.string.title, movie.title)
               movieOverview.text = context.getString(R.string.overview, movie.overview)
               movieRating.text = context.getString(R.string.rating, movie.vote_average)
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
       val currentMovie = movies[position]
        holder.bind(currentMovie)
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var movies: List<Result>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


}