package com.example.lindy_tummy.About

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lindy_tummy.databinding.FragmentDesaBinding
import com.example.lindy_tummy.databinding.FragmentTanahBinding

class TanahFragment : Fragment() {

    private var _binding: FragmentTanahBinding? = null
    private val binding get() = _binding!!
    private val tanahList = listOf(
        InfoModel("Sertifikat Tanah", "Informasi pembuatan sertifikat", "https://picsum.photos/seed/tanah1/400/300"),
        InfoModel("Pendaftaran Tanah", "Layanan pendaftaran bidang tanah", "https://picsum.photos/seed/tanah2/400/300"),
        InfoModel("Balik Nama", "Proses perubahan kepemilikan", "https://picsum.photos/seed/tanah3/400/300"),
        InfoModel("Pecah Sertifikat", "Pemecahan bidang tanah", "https://picsum.photos/seed/tanah4/400/300"),
        InfoModel("Penggabungan Tanah", "Penggabungan beberapa bidang", "https://picsum.photos/seed/tanah5/400/300"),
        InfoModel("Cek Sertifikat", "Validasi dokumen tanah", "https://picsum.photos/seed/tanah6/400/300"),
        InfoModel("Peta Bidang", "Informasi lokasi bidang", "https://picsum.photos/seed/tanah7/400/300"),
        InfoModel("Hak Milik", "Informasi hak atas tanah", "https://picsum.photos/seed/tanah8/400/300"),
        InfoModel("Hak Guna Bangunan", "Layanan HGB", "https://picsum.photos/seed/tanah9/400/300"),
        InfoModel("Hak Pakai", "Informasi hak pakai", "https://picsum.photos/seed/tanah10/400/300"),
        InfoModel("Pengukuran Tanah", "Layanan ukur tanah", "https://picsum.photos/seed/tanah11/400/300"),
        InfoModel("Sengketa Tanah", "Informasi penyelesaian sengketa", "https://picsum.photos/seed/tanah12/400/300"),
        InfoModel("Pajak Tanah", "Informasi PBB", "https://picsum.photos/seed/tanah13/400/300"),
        InfoModel("Tanah Wakaf", "Pengelolaan tanah wakaf", "https://picsum.photos/seed/tanah14/400/300"),
        InfoModel("Tanah Warisan", "Pengurusan waris tanah", "https://picsum.photos/seed/tanah15/400/300"),
        InfoModel("Pengecekan Batas", "Verifikasi batas bidang", "https://picsum.photos/seed/tanah16/400/300"),
        InfoModel("Perizinan Bangunan", "Informasi pembangunan", "https://picsum.photos/seed/tanah17/400/300"),
        InfoModel("Riwayat Tanah", "Data historis bidang tanah", "https://picsum.photos/seed/tanah18/400/300"),
        InfoModel("Alih Fungsi Lahan", "Perubahan penggunaan lahan", "https://picsum.photos/seed/tanah19/400/300"),
        InfoModel("Pendaftaran Online", "Layanan digital pertanahan", "https://picsum.photos/seed/tanah20/400/300"),
        InfoModel("Konsultasi Tanah", "Layanan konsultasi", "https://picsum.photos/seed/tanah21/400/300"),
        InfoModel("Arsip Sertifikat", "Dokumen pertanahan", "https://picsum.photos/seed/tanah22/400/300"),
        InfoModel("Peta Digital", "Visualisasi bidang tanah", "https://picsum.photos/seed/tanah23/400/300"),
        InfoModel("Informasi Zona", "Data tata ruang", "https://picsum.photos/seed/tanah24/400/300"),
        InfoModel("Validasi Data", "Pengecekan data pertanahan", "https://picsum.photos/seed/tanah25/400/300"),
        InfoModel("Pengaduan Masyarakat", "Layanan pengaduan", "https://picsum.photos/seed/tanah26/400/300"),
        InfoModel("Monitoring Tanah", "Pemantauan bidang tanah", "https://picsum.photos/seed/tanah27/400/300"),
        InfoModel("Legalisasi Tanah", "Layanan legalitas", "https://picsum.photos/seed/tanah28/400/300"),
        InfoModel("Informasi Agraria", "Data agraria desa", "https://picsum.photos/seed/tanah29/400/300"),
        InfoModel("Layanan Pertanahan", "Informasi umum pertanahan", "https://picsum.photos/seed/tanah30/400/300")
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTanahBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = InfoAdapter(tanahList) { item ->

            Toast.makeText(
                requireContext(),
                item.title,
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvTanah.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2
            )

            this.adapter = adapter
        }
    }
}