package com.example.lindy_tummy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.About.AboutFragment
import com.example.lindy_tummy.Home.HomeFragment
import com.example.lindy_tummy.Profile.ProfileFragment
import com.example.lindy_tummy.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragment default
        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.about -> {
                    replaceFragment(AboutFragment())
                    true
                }

                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}