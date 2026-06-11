package com.example.lindy_tummy.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lindy_tummy.AuthActivity
import com.example.lindy_tummy.Home.news.NewsAdapter
import com.example.lindy_tummy.R
import com.example.lindy_tummy.data.api.NewsApiClient
import com.example.lindy_tummy.data.model.NewsResponse
import com.example.lindy_tummy.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup All Click Listeners
        setupClickListeners()

        // Ambil Data Berita dari API Publik
        loadNewsData()
    }

    private fun setupClickListeners() {
        // Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {
            startActivity(Intent(requireContext(), BangunRuangActivity::class.java))
        }

        // Custom 1
        binding.btnCustom1.setOnClickListener {
            startActivity(Intent(requireContext(), Custom1Activity::class.java))
        }

        // Custom 2
        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(requireContext(), Custom2Activity::class.java))
        }

        // WebView
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = requireContext().getSharedPreferences(
                        "user_pref", AppCompatActivity.MODE_PRIVATE
                    )
                    sharedPref.edit().putBoolean("isLogin", false).apply()

                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    private fun loadNewsData() {
        // Memanggil API dengan cara standard yang biasa diajarkan di kampus
        com.example.lindy_tummy.data.api.NewsApiClient.apiService.getNews().enqueue(object : retrofit2.Callback<NewsResponse> {

            override fun onResponse(
                call: retrofit2.Call<NewsResponse>,
                response: retrofit2.Response<NewsResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    // Mengambil daftar artikel berita pertanahan dari dalam objek response body
                    val articlesList = response.body()!!.articles

                    // Ambil 10 data teratas agar tidak kepanjangan
                    val limitedNews = articlesList.take(10)

                    // Pasang ke RecyclerView melalui Adapter
                    val newsAdapter = com.example.lindy_tummy.Home.news.NewsAdapter(items = limitedNews)
                    binding.rvNews.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
                    binding.rvNews.adapter = newsAdapter
                }
            }

            override fun onFailure(call: retrofit2.Call<NewsResponse>, t: Throwable) {
                // Tampilkan pesan error jika internet putus atau API gagal merespon
                android.widget.Toast.makeText(
                    requireContext(),
                    "Gagal memuat berita pertanahan",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}