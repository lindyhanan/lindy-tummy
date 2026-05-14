package com.example.lindy_tummy.Home

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.lindy_tummy.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Web Bina Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // WebView
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://lindyy.alwaysdata.net")
    }

    // Tombol back toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}