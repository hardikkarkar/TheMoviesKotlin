package com.comet.moviesapp.ui.movie_detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.comet.moviesapp.data.model.Movie
import com.comet.moviesapp.data.repository.MovieDetailRepository
import com.comet.moviesapp.data.repository.MovieListRepository
import com.comet.moviesapp.utils.Constant
import com.comet.moviesapp.utils.Resource

class MovieDetailViewModel
@ViewModelInject constructor(private val repository: MovieDetailRepository) : ViewModel() {

    fun getMovieDetail(movieId: String): LiveData<Resource<Movie>> = repository.getMovieDetail(
        apiKey = Constant.API_KEY,
        language = Constant.LANGUAGE,
        movie_id = movieId
    )
}