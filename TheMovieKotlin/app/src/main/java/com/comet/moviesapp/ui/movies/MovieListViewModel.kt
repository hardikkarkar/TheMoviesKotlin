package com.comet.moviesapp.ui.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.comet.moviesapp.data.model.Movie
import com.comet.moviesapp.data.repository.MovieListRepository
import com.comet.moviesapp.utils.Constant
import com.comet.moviesapp.utils.Resource

class MovieListViewModel
@ViewModelInject constructor(private val repository: MovieListRepository) : ViewModel() {

    val result = repository.getMoviesList(
        apiKey = Constant.API_KEY,
        language = Constant.LANGUAGE,
        page = 1
    )

}