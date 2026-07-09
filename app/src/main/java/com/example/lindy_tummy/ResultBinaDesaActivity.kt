package com.example.lindy_tummy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityResultBinaDesaBinding // Sesuaikan dengan nama layout XML Anda

class ResultBinaDesaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinaDesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinaDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data email yang dikirim dari halaman input sebelumnya
        val emailPendaftar = intent.getStringExtra("EMAIL_PENDAFTAR") ?: "-"

        // Menampilkan teks sukses di layar (Sesuaikan id view-nya dengan XML Anda)
        binding.tvStatus.text = "Pendaftaran Berhasil!"
        binding.tvKeterangan.text = "Email pengaduan/aspirasi warga desa dari ($emailPendaftar) telah berhasil dijadwalkan ke sistem antrean Bina Desa."
    }
}