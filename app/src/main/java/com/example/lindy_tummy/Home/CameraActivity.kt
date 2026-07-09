package com.example.lindy_tummy.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityCameraBinding // Otomatis berubah jika layout di-rename menjadi activity_camera.xml
import com.google.android.material.tabs.TabLayoutMediator

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Menggunakan adapter yang sama
        val adapter = CameraTabsAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Ambil Foto"
                1 -> "Scan QR"
                2 -> "Buat QR"
                else -> ""
            }
        }.attach()
    }
}