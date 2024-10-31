package edu.temple.browsr

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider

const val VIEW_MODEL = "viewModel"
class PageFragment : Fragment() {
    private var reload = true

    interface ControlActions {
        fun back()
        fun forward()
    }

    private val viewModel: LinkViewModel by lazy {
        ViewModelProvider(requireActivity())[LinkViewModel::class.java]
    }
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_page, container, false).apply {
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                reload = false
                viewModel.setLink(url)
                reload = true
            }
        }

        if(savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        } else {
            viewModel.getLink().observe(requireActivity()) {
                if (reload)
                    webView.loadUrl(it)
            }
        }
    }

    fun back() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
    }
    fun forward() {
        if (webView.canGoForward())
            webView.goForward()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }
}