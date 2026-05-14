package com.example.lindy_tummy.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityCustom2Binding

class Custom2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Custom 2"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Intent Data
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        binding.tvTitle.text = title ?: "Custom 2"
        binding.tvDesc.text = desc ?: "Halaman custom kedua"
    }

    // Tombol back toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}