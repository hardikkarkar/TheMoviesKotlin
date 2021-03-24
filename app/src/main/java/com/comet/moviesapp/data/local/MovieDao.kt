package com.comet.moviesapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.comet.moviesapp.data.model.Movie

@Dao
abstract class MovieDao {

    @Query("SELECT * FROM movie")
    abstract fun getMoviesList(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(movies: Movie?)

    @Query("SELECT * FROM movie WHERE id LIKE :movie_id")
    abstract fun getMovieDetail(movie_id: String): LiveData<Movie>
}