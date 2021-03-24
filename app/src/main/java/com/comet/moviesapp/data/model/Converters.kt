package com.comet.moviesapp.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromGenresList(string: List<Genres?>?): String? {
        val type = object : TypeToken<List<Genres>>() {}.type
        return Gson().toJson(string, type)
    }

    @TypeConverter
    fun toGenresList(string: String?): List<Genres>? {
        val type = object : TypeToken<List<Genres>>() {}.type
        return Gson().fromJson<List<Genres>>(string, type)
    }

    @TypeConverter
    fun fromCompaniesList(string: List<Production_companies?>?): String? {
        val type = object : TypeToken<List<Production_companies>>() {}.type
        return Gson().toJson(string, type)
    }

    @TypeConverter
    fun toCompaniesList(string: String?): List<Production_companies>? {
        val type = object : TypeToken<List<Production_companies>>() {}.type
        return Gson().fromJson<List<Production_companies>>(string, type)
    }

    @TypeConverter
    fun fromCountriesList(string: List<Production_countries?>?): String? {
        val type = object : TypeToken<List<Production_countries>>() {}.type
        return Gson().toJson(string, type)
    }

    @TypeConverter
    fun toCountriesList(string: String?): List<Production_countries>? {
        val type = object : TypeToken<List<Production_countries>>() {}.type
        return Gson().fromJson<List<Production_countries>>(string, type)
    }

    @TypeConverter
    fun fromLanguageList(string: List<Spoken_languages?>?): String? {
        val type = object : TypeToken<List<Spoken_languages>>() {}.type
        return Gson().toJson(string, type)
    }

    @TypeConverter
    fun toLanguageList(string: String?): List<Spoken_languages>? {
        val type = object : TypeToken<List<Spoken_languages>>() {}.type
        return Gson().fromJson<List<Spoken_languages>>(string, type)
    }

//    @TypeConverter
//    fun fromDetails(countryLang: Details?): String? {
//        val type = object : TypeToken<Details>() {}.type
//        return Gson().toJson(countryLang, type)
//    }
//
//    @TypeConverter
//    fun toDetails(countryLangString: String?): Details? {
//        val type = object : TypeToken<Details>() {}.type
//        return Gson().fromJson<Details>(countryLangString, type)
//    }

    @TypeConverter
    fun stringListToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}