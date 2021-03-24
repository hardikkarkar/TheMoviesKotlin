package com.comet.moviesapp.data.model


import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id") val id: Long,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName("belongs_to_collection") val belongs_to_collection: String?,
    @SerializedName("budget") val budget: Int?,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("imdb_id") val imdb_id: String?,
    @SerializedName("original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("release_date") val release_date: String?,
    @SerializedName("revenue") val revenue: Int?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("status") val status: String?,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val vote_average: Double?,
    @SerializedName("vote_count") val vote_count: Int?,
    @SerializedName("genres") val genres: List<Genres>?,
    @SerializedName("production_companies") val production_companies: List<Production_companies>?,
    @SerializedName("production_countries") val production_countries: List<Production_countries>?,
    @SerializedName("spoken_languages") val spoken_languages: List<Spoken_languages>?
)