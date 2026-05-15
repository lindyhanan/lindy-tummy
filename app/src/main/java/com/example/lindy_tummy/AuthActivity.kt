package com.example.lindy_tummy

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnSubmit.setOnClickListener {

            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)

            if (username.isEmpty() || password.isEmpty()) {
                showError("Username dan Password wajib diisi")
                return@setOnClickListener
            }

            val loginValid =
                savedUsername != null &&
                        savedPassword != null &&
                        username == savedUsername &&
                        password == savedPassword

            if (loginValid) {
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                showError("Login gagal! Username atau password salah")
            }
        }

        binding.btnRegisterGmail.setOnClickListener {
            startActivity(Intent(this, InputGmailActivity::class.java))
        }
    }

    private fun showError(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Login Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}