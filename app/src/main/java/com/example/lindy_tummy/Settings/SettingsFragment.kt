package com.example.lindy_tummy.Settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    // DATA LIST
    private val settingList = listOf(
        "Privacy Policy",
        "About Application",
        "Developer Profile",
        "Help Center",
        "Terms & Conditions",
        "Logout"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ArrayAdapter
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            settingList
        )

        binding.listViewSettings.adapter = adapter

        // ON CLICK ITEM
        binding.listViewSettings.setOnItemClickListener { _, _, position, _ ->

            val selectedItem = settingList[position]

            Toast.makeText(
                requireContext(),
                "Kamu memilih: $selectedItem",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}