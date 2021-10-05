package com.example.moviesretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndpoints {
    @GET("/3/movie/popular")

    fun getMovies(@Query("742734cffa22a93e0b1cc6d85e8cdb12") key: String): Call<PopularMovies>

}