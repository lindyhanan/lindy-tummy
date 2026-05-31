package com.example.lindy_tummy.About

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lindy_tummy.R
import com.example.lindy_tummy.databinding.ActivityTanahBinding
import com.google.android.material.tabs.TabLayoutMediator

class TanahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTanahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTanahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Info Pertanahan"
            setHomeAsUpIndicator(R.drawable.ic_arrow)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val tabsAdapter = AboutTabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 menggunakan Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Atur judul untuk setiap tab
            when (position) {
                0 -> tab.text = "DESA"
                1 -> tab.text = "TANAH"
            }
        }.attach()
    }
}