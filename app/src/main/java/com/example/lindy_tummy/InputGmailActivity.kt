package com.example.lindy_tummy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityInputGmailBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class InputGmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputGmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInputGmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {

            val email = binding.etEmail.text.toString().trim()

            if (email.isEmpty()) {
                showError("Email tidak boleh kosong")
                return@setOnClickListener
            }

            if (!email.endsWith("@gmail.com")) {
                showError("Email harus menggunakan @gmail.com")
                return@setOnClickListener
            }

            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("EMAIL", email)
            startActivity(intent)
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