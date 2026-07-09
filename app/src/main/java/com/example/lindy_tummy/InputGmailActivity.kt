package com.example.lindy_tummy

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityInputGmailBinding
import com.example.lindy_tummy.utils.PermissionHelper
import com.example.lindy_tummy.utils.ReminderHelper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.Calendar

class InputGmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputGmailBinding

    // Launcher untuk meminta izin notifikasi otomatis pada Android 13 ke atas
    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Izin notifikasi diberikan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Izin ditolak, pengingat tidak akan muncul di layar", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInputGmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Minta izin Notifikasi ke sistem Android begitu halaman diakses
        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(notificationPermissionLauncher, permission)
            }
        }

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
            val intentKeHalamanHasil = Intent(this, ResultBinaDesaActivity::class.java).apply {
                putExtra("EMAIL_PENDAFTAR", email)
            }
            startActivity(intentKeHalamanHasil)
            val calendar = Calendar.getInstance().apply {
                add(Calendar.MINUTE, 1)
            }

            // 4. Memicu AlarmManager untuk menembak Notifikasi Lokal
            ReminderHelper.setReminder(
                context = this,
                hour = calendar.get(Calendar.HOUR_OF_DAY),
                minute = calendar.get(Calendar.MINUTE),
                title = "Agenda Bina Desa Aktif",
                message = "Halo admin ($email), saatnya verifikasi berkas aspirasi warga desa di sistem!",
                targetActivity = ResultBinaDesaActivity::class.java // Saat notifikasi diklik, balik ke halaman ini
            )

            Toast.makeText(this, "Data dikirim! Pengingat diset 1 menit lagi.", Toast.LENGTH_LONG).show()
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