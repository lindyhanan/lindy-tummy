package com.example.lindy_tummy.Profile

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.MainActivity
import com.example.lindy_tummy.R
import com.example.lindy_tummy.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val CHANNEL_ID = "bina_desa_notification"
    private val NOTIFICATION_ID = 101

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Membuat Notification Channel (Wajib untuk Android 8.0 ke atas)
        createNotificationChannel()

        // ASUMSI: Tombol Kirim/Pesan di XML kamu.
        // Silakan sesuaikan ID tombolnya (misal: btnKirim atau nama tombol di layoutmu)
        binding.btnSend.setOnClickListener {
            // Mengambil input dari EditText Email
            // Sesuaikan id etEmail dengan yang ada di activity_profile_fragment.xml kamu
            val emailInput = binding.etEmail.text.toString().trim()

            if (emailInput.isNotEmpty()) {
                // Tampilkan pesan sukses lokal
                Toast.makeText(requireContext(), "Aspirasi terkirim via $emailInput", Toast.LENGTH_SHORT).show()

                // Picu Local Notification Instan!
                showLocalNotification(emailInput)
            } else {
                Toast.makeText(requireContext(), "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLocalNotification(email: String) {
        val context = requireContext()

        // Intent ketika Notifikasi diklik -> Membuka MainActivity (atau halaman Result jika mau)
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Membangun struktur konten Notifikasi
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Ganti dengan ikon aplikasi kamu jika ada
            .setContentTitle("Agenda Bina Desa Aktif!")
            .setContentText("Laporan aspirasi dari $email berhasil diproses.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent) // Aksi saat diklik
            .setAutoCancel(true) // Notifikasi hilang setelah diklik

        // Menampilkan Notifikasi ke Layar HP
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notifikasi Bina Desa"
            val descriptionText = "Saluran informasi pengiriman aspirasi warga"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}