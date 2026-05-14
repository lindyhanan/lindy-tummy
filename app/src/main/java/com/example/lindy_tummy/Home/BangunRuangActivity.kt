package com.example.lindy_tummy.Home

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityBangunRuangBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class BangunRuangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Bangun Ruang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        binding.tvTitle.text = title ?: "Rumus Persegi"
        binding.tvDesc.text = desc ?: "Menghitung luas persegi"

        // Tombol hitung luas persegi
        binding.btnHitung.setOnClickListener {

            val sisiText = binding.etSisi.text.toString()

            if (sisiText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Masukkan sisi terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                val sisi = sisiText.toDouble()
                val hasil = sisi * sisi
                binding.tvHasil.text = "Hasil Luas Persegi : $hasil"
            }
        }

        // Snackbar
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Ini adalah Snackbar",
                Snackbar.LENGTH_SHORT
            )
                .setAction("Tutup") {
                    Log.d("Snackbar", "Ditutup")
                }
                .show()
        }

        // AlertDialog
        binding.btnShowDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah lanjut?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.d("Dialog", "Ya")
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    // Tombol back toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}