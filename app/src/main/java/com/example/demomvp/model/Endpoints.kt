package com.example.demomvp.model

import retrofit2.Call
import com.example.dbmkotlin.Model.Movies
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {
    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey: String, @Query("page") page: Int): Call<Movies>

    companion object {
        val urlApi = "https://api.themoviedb.org/3/"

        fun create(): Endpoints {
            val retrofit = Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Endpoints::class.java)
        }

    }
}