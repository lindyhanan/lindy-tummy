package com.example.lindy_tummy.About

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lindy_tummy.databinding.FragmentDesaBinding

class DesaFragment : Fragment() {

    private var _binding: FragmentDesaBinding? = null
    private val binding get() = _binding!!

    private val desaList = listOf(
        InfoModel("Pelatihan UMKM", "Pengembangan usaha masyarakat desa", "https://picsum.photos/seed/desa1/400/300"),
        InfoModel("Literasi Digital", "Pelatihan penggunaan teknologi", "https://picsum.photos/seed/desa2/400/300"),
        InfoModel("Bank Sampah", "Pengelolaan sampah desa", "https://picsum.photos/seed/desa3/400/300"),
        InfoModel("Posyandu", "Pelayanan kesehatan masyarakat", "https://picsum.photos/seed/desa4/400/300"),
        InfoModel("Pertanian Modern", "Pemanfaatan teknologi pertanian", "https://picsum.photos/seed/desa5/400/300"),
        InfoModel("Pelatihan Komputer", "Belajar dasar komputer", "https://picsum.photos/seed/desa6/400/300"),
        InfoModel("Budidaya Ikan", "Pengembangan sektor perikanan", "https://picsum.photos/seed/desa7/400/300"),
        InfoModel("Koperasi Desa", "Penguatan ekonomi warga", "https://picsum.photos/seed/desa8/400/300"),
        InfoModel("Pendidikan Anak", "Program belajar masyarakat", "https://picsum.photos/seed/desa9/400/300"),
        InfoModel("Penghijauan", "Penanaman pohon desa", "https://picsum.photos/seed/desa10/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDesaBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = InfoAdapter(desaList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.title}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvDesa.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            this.adapter = adapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}