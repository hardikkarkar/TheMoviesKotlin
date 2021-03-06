/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.comet.moviesapp.data.remote

import com.comet.moviesapp.data.model.Movie
import com.comet.moviesapp.data.model.PopularMoviesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Used to connect to the Unsplash API to fetch photos
 */
interface APIService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String,
        @Query("language") language: String,
        @Query("page") page: Number,
    ): Response<PopularMoviesResponse>

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(
        @Path("movie_id") movie_id: String,
        @Query("api_key") apikey: String,
        @Query("language") language: String
    ): Response<Movie>

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): APIService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BODY}

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
        }
    }
}
