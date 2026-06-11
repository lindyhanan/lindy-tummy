package com.example.lindy_tummy.Home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lindy_tummy.data.model.NewsModel
import com.example.lindy_tummy.databinding.ItemNewsBinding

class NewsAdapter(private val items: List<NewsModel>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = items[position]

        // 1. Menampilkan judul berita pertanahan asli
        holder.binding.tvNewsTitle.text = item.title

        // 2. DIUBAH: Menggunakan item.description untuk isi/deskripsi berita
        holder.binding.tvNewsDesc.text = item.description

        // 3. DIUBAH: Menggunakan urlToImage langsung dari API berita asli (bukan placeholder picsum)
        val imageUrl = item.urlToImage

        // 4. Glide otomatis memuat gambar asli dari portal berita (detik/kompas/dll)
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(android.R.drawable.progress_horizontal) // Gambar pemuat sementara jika internet lambat
            .error(android.R.drawable.stat_notify_error) // Gambar jika link dari berita rusak
            .into(holder.binding.imgNews)
    }

    override fun getItemCount(): Int = items.size
}