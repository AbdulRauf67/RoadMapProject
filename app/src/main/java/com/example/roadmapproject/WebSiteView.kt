package com.example.roadmapproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.example.roadmapproject.databinding.ActivityWebSiteViewBinding

@Suppress("DEPRECATION")
class WebSiteView : AppCompatActivity() {
    private lateinit var binding: ActivityWebSiteViewBinding
    private lateinit var webViewSite:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_site_view)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_web_site_view)
        webViewSite=binding.webViewDesign
        webViewSite.webViewClient= WebViewClient()
        webViewSite.loadUrl("https://www.geeksforgeeks.org/android-webview-in-kotlin/amp/")
        webViewSite.settings.javaScriptEnabled=true
        webViewSite.settings.setSupportZoom(true)

    }

    override fun onBackPressed() {
        if (webViewSite.canGoBack()){
            webViewSite.goBack()
        }else {
            super.onBackPressed()
        }
    }
}