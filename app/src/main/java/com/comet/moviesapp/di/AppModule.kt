package com.comet.moviesapp.di

import android.content.Context
import com.comet.moviesapp.data.local.AppDatabase
import com.comet.moviesapp.data.local.MovieDao
import com.comet.moviesapp.data.remote.APIService
import com.comet.moviesapp.data.repository.MovieListRepository
import com.example.rickandmorty.data.remote.MoviesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(apiService: APIService) = MoviesRemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase) = db.movieDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: MoviesRemoteDataSource,
                          localDataSource: MovieDao) =
        MovieListRepository(remoteDataSource, localDataSource)
}