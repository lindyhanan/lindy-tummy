package com.example.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityBangunRuangBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class BangunRuangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        binding.tvTitle.text = title
        binding.tvDesc.text = desc

        // Snackbar
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    Log.e("Snackbar","Ditutup")
                }
                .show()
        }

        // AlertDialog
        binding.btnShowDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah lanjut?")
                .setPositiveButton("Ya"){d,_ ->
                    d.dismiss()
                    Log.e("Dialog","Ya")
                }
                .setNegativeButton("Tidak"){d,_ ->
                    d.dismiss()
                }
                .show()
        }
    }
}