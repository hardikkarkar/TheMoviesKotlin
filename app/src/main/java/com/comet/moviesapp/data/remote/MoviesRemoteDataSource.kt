package com.comet.moviesapp.data.remote

import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : BaseDataSource() {
    suspend fun getMoviesList(
        apikey: String,
        language: String, page: Number,
    ) = getResult { apiService.getPopularMovies(apikey, language, page) }

    suspend fun getMovieDetail(
        apikey: String,
        language: String,
        movie_id: String,
    ) = getResult { apiService.getMoviesDetail(movie_id, apikey, language, ) }
}