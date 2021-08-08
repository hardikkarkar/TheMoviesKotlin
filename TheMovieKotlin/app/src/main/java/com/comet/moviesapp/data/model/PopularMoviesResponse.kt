package com.comet.moviesapp.data.model

import com.google.gson.annotations.SerializedName


data class PopularMoviesResponse(
    @field:SerializedName("results") val results: List<Movie>,
    @field:SerializedName("page") val page: Long,
    @field:SerializedName("total_pages") val total_pages: Long,
    @field:SerializedName("total_results") val total_results: Long,
)
