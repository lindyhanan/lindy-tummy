package com.example.lindy_tummy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklarasi variabel untuk semua view
    private var alas: EditText? = null
    private var tinggi: EditText? = null
    private var sisi: EditText? = null
    private var btnSegitiga: Button? = null
    private var btnKubus: Button? = null
    private var hasil: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan layout XML ke Activity
        setContentView(R.layout.activity_main)

        // Mengambil semua view dari XML
        alas = findViewById(R.id.etAlas)
        tinggi = findViewById(R.id.etTinggi)
        sisi = findViewById(R.id.etSisi)
        btnSegitiga = findViewById(R.id.btnSegitiga)
        btnKubus = findViewById(R.id.btnKubus)
        hasil = findViewById(R.id.tvHasil)

        // Tombol hitung Segitiga
        btnSegitiga!!.setOnClickListener {
            val a = alas!!.text.toString()
            val t = tinggi!!.text.toString()

            if (a.isEmpty() || t.isEmpty()) {
                hasil!!.text = "Isi dulu ya"
            } else {
                try {
                    val alas1 = a.toDouble()
                    val tinggi1 = t.toDouble()
                    val luas = 0.5 * alas1 * tinggi1
                    hasil!!.text = "Luas segitiga = $luas"
                } catch (e: NumberFormatException) {
                    hasil!!.text = "Input harus angka"
                }
            }

            // Contoh penggunaan Toast & event listener
            Toast.makeText(applicationContext, "Anda telah klik tombol Segitiga", Toast.LENGTH_SHORT).show()
        }

        // Tombol hitung Kubus
        btnKubus!!.setOnClickListener {
            val s = sisi!!.text.toString()

            if (s.isEmpty()) {
                hasil!!.text = "Masukkan sisi dulu"
            } else {
                try {
                    val sisi1 = s.toDouble()
                    val volume = sisi1 * sisi1 * sisi1
                    hasil!!.text = "Volume kubus = $volume"
                } catch (e: NumberFormatException) {
                    hasil!!.text = "Input harus angka"
                }
            }

            Toast.makeText(applicationContext, "Anda telah klik tombol Kubus", Toast.LENGTH_SHORT).show()
        }

        // Catatan praktikum:
        // - Activity: MainActivity
        // - Layout: activity_main.xml
        // - Package: com.example.lindy_tummy
        // - Logcat: digunakan untuk cek error / debugging
        // - Emulator: digunakan untuk menjalankan dan testing aplikasi
        // - Event Listener: tombol btnSegitiga & btnKubus
    }
}