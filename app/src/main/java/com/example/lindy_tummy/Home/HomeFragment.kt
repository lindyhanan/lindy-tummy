package com.example.lindy_tummy.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lindy_tummy.AuthActivity
import com.example.lindy_tummy.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {

            startActivity(
                Intent(requireContext(), BangunRuangActivity::class.java)
            )
        }

        // Custom 1
        binding.btnCustom1.setOnClickListener {

            startActivity(
                Intent(requireContext(), Custom1Activity::class.java)
            )
        }

        // Custom 2
        binding.btnCustom2.setOnClickListener {

            startActivity(
                Intent(requireContext(), Custom2Activity::class.java)
            )
        }

        // WebView
        binding.btnWebView.setOnClickListener {

            startActivity(
                Intent(requireContext(), WebViewActivity::class.java)
            )
        }

        // Logout
        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    val sharedPref = requireContext()
                        .getSharedPreferences(
                            "user_pref",
                            AppCompatActivity.MODE_PRIVATE
                        )

                    sharedPref.edit()
                        .putBoolean("isLogin", false)
                        .apply()

                    startActivity(
                        Intent(requireContext(), AuthActivity::class.java)
                    )

                    requireActivity().finish()
                }

                .setNegativeButton("Tidak", null)
                .show()
        }

        return binding.root
    }
}