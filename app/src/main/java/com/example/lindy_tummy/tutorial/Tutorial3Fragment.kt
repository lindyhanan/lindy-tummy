package com.example.lindy_tummy.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.AuthActivity
import com.example.lindy_tummy.R
import com.example.lindy_tummy.databinding.FragmentTutorial3Binding

class Tutorial3Fragment : Fragment(R.layout.fragment_tutorial3) {
    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTutorial3Binding.bind(view)

        binding.btnAyoMulai.setOnClickListener {
            // Berpindah ke halaman Login (AuthActivity)
            val intent = Intent(requireContext(), AuthActivity::class.java)
            startActivity(intent)
            requireActivity().finish() // Tutup activity onboarding agar tidak bisa di-back
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}