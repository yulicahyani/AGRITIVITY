package com.bc0098.agritivity.ui.panduan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.bc0098.agritivity.R
import com.bc0098.agritivity.databinding.ActivityYoutubViewBinding

class YoutubeViewActivity : AppCompatActivity() {

    companion object{
        const val VIDEO_URL = "video_url"
    }

    private  lateinit var activityYoutubViewBinding: ActivityYoutubViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityYoutubViewBinding = ActivityYoutubViewBinding.inflate(layoutInflater)
        setContentView(activityYoutubViewBinding.root)

        val videoUrl = intent.getStringExtra(VIDEO_URL)
        val webView = activityYoutubViewBinding.webview
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Youtube berhasil dimuat')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(this@YoutubeViewActivity, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }

        if (videoUrl != null) {
            webView.loadUrl(videoUrl)
        }
    }
}