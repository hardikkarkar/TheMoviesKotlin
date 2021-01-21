package com.comet.moviesapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.comet.moviesapp.data.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovies() : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)


}