package com.example.lindy_tummy.data.api

import com.example.lindy_tummy.data.model.NewsModel
import com.example.lindy_tummy.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    // Mencari berita Indonesia dengan kata kunci pertanahan / agraria
    @GET(value = "v2/everything?q=tanah OR agraria OR sertifikat&language=id&sortBy=publishedAt")
    fun getNews(
        @Query("apiKey") apiKey: String = "MASUKKAN_API_KEY_MEREKA_DI_SINI"
    ): Call<NewsResponse>
}