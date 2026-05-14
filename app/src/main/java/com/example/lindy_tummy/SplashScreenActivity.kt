package com.example.lindy_tummy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lindy_tummy.databinding.ActivityCustom1Binding
import com.example.lindy_tummy.databinding.ActivityDashboardBinding
import com.example.lindy_tummy.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            // Delay splash 2 detik
            delay(2000)
            // SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            // Cek login
            if (isLogin) {
                // Jika sudah login → Dashboard
                val intent =
                    Intent(this@SplashScreenActivity, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                // Jika belum login → Auth
                val intent =
                    Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }

            finish()
        }
    }
}