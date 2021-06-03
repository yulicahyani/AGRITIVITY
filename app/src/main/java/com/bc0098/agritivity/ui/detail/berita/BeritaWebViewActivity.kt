package com.bc0098.agritivity.ui.detail.berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.bc0098.agritivity.databinding.ActivityBeritaWebViewBinding

class BeritaWebViewActivity : AppCompatActivity() {

    companion object{
        const val BERITA_URL = "berita_url"
    }

    private lateinit var activityBeritaWebViewBinding: ActivityBeritaWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBeritaWebViewBinding = ActivityBeritaWebViewBinding.inflate(layoutInflater)
        setContentView(activityBeritaWebViewBinding.root)

        val url = intent.getStringExtra(BERITA_URL)
        val webView = activityBeritaWebViewBinding.webview
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Berita berhasil dimuat')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(this@BeritaWebViewActivity, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }

        if (url != null) {
            webView.loadUrl(url)
        }
    }
}