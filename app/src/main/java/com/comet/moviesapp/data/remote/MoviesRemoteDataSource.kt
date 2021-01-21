package com.example.rickandmorty.data.remote

import com.comet.moviesapp.data.remote.APIService
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : BaseDataSource() {
    suspend fun getMovies(
        apikey: String,
        language: String, page: Number,
    ) = getResult { apiService.getPopularMovies(apikey, language, page) }
}