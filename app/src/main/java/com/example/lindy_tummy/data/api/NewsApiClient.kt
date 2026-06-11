package com.example.lindy_tummy.data.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object NewsApiClient {
    private const val BASE_URL = "https://newsapi.org/"
    val apiService: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}