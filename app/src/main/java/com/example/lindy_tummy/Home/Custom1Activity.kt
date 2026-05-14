package com.example.lindy_tummy.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityCustom1Binding

class Custom1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustom1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Custom 1"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Intent Data
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        binding.tvTitle.text = title ?: "Custom 1"
        binding.tvDesc.text = desc ?: "Halaman custom pertama"
    }

    // Tombol back toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}