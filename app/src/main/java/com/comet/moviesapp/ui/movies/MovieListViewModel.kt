package com.comet.moviesapp.ui.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.comet.moviesapp.data.repository.MovieListRepository
import com.comet.moviesapp.utils.Constant

class MovieListViewModel
    @ViewModelInject constructor(private val repository: MovieListRepository)
    : ViewModel() {

    val result = repository.getMovies(
        apiKey = Constant.API_KEY,
        language = Constant.LANGUAGE,
        page = 1
    )

}