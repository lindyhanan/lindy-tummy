package com.example.lindy_tummy.data.model

data class NewsModel(
    val title: String,       // Judul Berita
    val description: String, // Deskripsi singkat / isi berita (pengganti 'body')
    val url: String,         // Link ke website berita aslinya
    val urlToImage: String   // Link gambar berita untuk pelengkap visual
)
// Objek penampung bungkus luar dari API
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsModel>
)

// Objek artikel berita pertanahan yang akan dipajang
