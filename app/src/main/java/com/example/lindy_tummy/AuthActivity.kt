package com.example.lindy_tummy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnSubmit.setOnClickListener {

            // Ambil input
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Validasi
            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Username dan Password wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // Simpan login
                val editor = sharedPref.edit()

                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.putString("password", password)

                editor.apply()

                // Pindah ke Dashboard
                val intent = Intent(this, BaseActivity::class.java)

                intent.putExtra("title", "Dashboard")
                intent.putExtra("desc", "Halaman utama aplikasi")

                startActivity(intent)
                finish()
            }
        }
    }
}