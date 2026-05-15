package com.example.lindy_tummy

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        val email = intent.getStringExtra("EMAIL")
        binding.etEmail.setText(email)
        binding.etEmail.isEnabled = false

        binding.btnSubmit.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
                showError("Semua field wajib diisi")
                return@setOnClickListener
            }

            if (password.length < 6) {
                showError("Password minimal 6 karakter")
                return@setOnClickListener
            }

            if (username.contains(" ")) {
                showError("Username tidak boleh mengandung spasi")
                return@setOnClickListener
            }

            // SIMPAN DATA
            sharedPref.edit()
                .putString("name", name)
                .putString("username", username)
                .putString("password", password)
                .putString("email", email)
                .apply()

            startActivity(Intent(this, SuccessActivity::class.java))
            finish()
        }
    }

    private fun showError(msg: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }
}