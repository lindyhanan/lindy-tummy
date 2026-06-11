package com.example.lindy_tummy.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lindy_tummy.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentsList = listOf(Tutorial1Fragment(), Tutorial2Fragment(), Tutorial3Fragment())

        // Menggunakan Anonymous Class Adapter agar praktis
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragmentsList.size
            override fun createFragment(position: Int): Fragment = fragmentsList[position]
        }

        binding.viewPagerOnboarding.adapter = adapter
        binding.dotIndicator.attachTo(binding.viewPagerOnboarding)
    }
}