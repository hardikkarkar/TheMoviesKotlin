package com.comet.moviesapp.data.repository

import com.comet.moviesapp.data.local.MovieDao
import com.comet.moviesapp.data.remote.MoviesRemoteDataSource
import com.comet.moviesapp.utils.performGetOperation
import javax.inject.Inject

class MovieListRepository @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MovieDao
) {
    fun getMoviesList(apiKey: String, language: String, page: Int) = performGetOperation(
        databaseQuery = { localDataSource.getMoviesList() },
        networkCall = { remoteDataSource.getMoviesList(apiKey, language, page) },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )

    fun getMovieDetail(apiKey: String, language: String, movie_id: String) = performGetOperation(
        databaseQuery = { localDataSource.getMovieDetail(movie_id) },
        networkCall = { remoteDataSource.getMovieDetail(apiKey, language, movie_id) },
        saveCallResult = { localDataSource.insert(it) }
    )
}