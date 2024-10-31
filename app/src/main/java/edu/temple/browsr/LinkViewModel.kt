package edu.temple.browsr

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LinkViewModel : ViewModel() {
    val default_site = "https://www.google.com"
    private val link = MutableLiveData<String>(default_site)
    private val visible_link = MutableLiveData<String>(default_site)

    fun setLink(url: String?) {
        link.value = url
        Log.d("LinkViewModel", "Set link to: ${link.value}")
    }

    fun getLink(): LiveData<String> = link

    fun setVisibleLink(url: String?) {
        visible_link.value = url
    }

    fun getVisibleLink(): LiveData<String> = visible_link
}