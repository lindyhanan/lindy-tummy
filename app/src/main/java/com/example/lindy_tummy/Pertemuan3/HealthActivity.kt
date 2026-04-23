package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityHealthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HealthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHealthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "HealthActivity dibuat")

        // Tombol 1 → Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(this, BangunRuangActivity::class.java)
            intent.putExtra("title", "Rumus Bangun Ruang")
            intent.putExtra("desc", "Halaman rumus bangun ruang")
            startActivity(intent)
        }

        // Tombol 2 → Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("title", "Custom 1")
            intent.putExtra("desc", "Halaman custom pertama")
            startActivity(intent)
        }

        // Tombol 3 → Custom 2
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("title", "Custom 2")
            intent.putExtra("desc", "Halaman custom kedua")
            startActivity(intent)
        }

        // Tombol 4 → Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()

                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "HealthActivity dihapus")
    }
}