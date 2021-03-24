package com.comet.moviesapp.data.repository

import com.comet.moviesapp.data.local.MovieDao
import com.comet.moviesapp.data.remote.MoviesRemoteDataSource
import com.comet.moviesapp.utils.performGetOperation
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MovieDao
) {
    fun getMovieDetail(apiKey: String, language: String, movie_id: String) = performGetOperation(
        databaseQuery = { localDataSource.getMovieDetail(movie_id) },
        networkCall = { remoteDataSource.getMovieDetail(apiKey, language, movie_id) },
        saveCallResult = { localDataSource.insert(it) }
    )
}