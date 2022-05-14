package com.example.simpleuielements.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.AppCompatEditText
import com.example.simpleuielements.R
import com.example.simpleuielements.util.toast
import com.google.android.material.button.MaterialButton

class ThirdActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var btnSearch: MaterialButton
    private lateinit var editSearch: AppCompatEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        initViews()

    }

    private fun initViews() {
        webView = findViewById(R.id.webView)
        btnSearch = findViewById(R.id.btnSearch)
        editSearch = findViewById(R.id.editSearch)
        btnSearch.setOnClickListener {
            searchSite()
        }
    }

    private fun searchSite() {
        val query: String = editSearch.text.toString().trim()
        if (query.isNotEmpty()) {
            webView.loadUrl(query)
            val webSettings = webView.settings
            webSettings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
        } else {
            toast("Please enter query")
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}