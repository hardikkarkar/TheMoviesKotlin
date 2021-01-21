package com.comet.moviesapp.data.repository

import com.comet.moviesapp.data.local.MovieDao
import com.example.rickandmorty.data.remote.MoviesRemoteDataSource
import com.comet.moviesapp.utils.performGetOperation
import javax.inject.Inject

class MovieListRepository @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MovieDao
) {
    fun getMovies(apiKey: String, language: String, page: Int) = performGetOperation(
        databaseQuery = { localDataSource.getAllMovies() },
        networkCall = { remoteDataSource.getMovies(apiKey, language, page) },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}