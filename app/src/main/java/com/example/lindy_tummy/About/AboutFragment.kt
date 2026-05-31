package com.example.lindy_tummy.About

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.databinding.FragmentAboutBinding
import com.google.android.material.chip.Chip

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        // CHIP CLICK
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(
                    requireContext(),
                    "Filter: ${chip.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.btnTanah.setOnClickListener {
            startActivity(
                Intent(requireContext(), TanahActivity::class.java)
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}