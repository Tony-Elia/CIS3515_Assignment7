package edu.temple.browsr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider

class PageFragment : Fragment() {
    private val viewModel: LinkViewModel by lazy {
        ViewModelProvider(requireActivity())[LinkViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_page, container, false).apply {
            val webView = findViewById<WebView>(R.id.webView)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient();

            viewModel.getLink().observe(requireActivity()) {
                webView.loadUrl(it)
            }
        }
}