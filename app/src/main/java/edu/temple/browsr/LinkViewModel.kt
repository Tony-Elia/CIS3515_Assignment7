package edu.temple.browsr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LinkViewModel : ViewModel() {
    private val link = MutableLiveData<String>("https://www.google.com")

    fun setLink(url: String) {
        link.value = url
    }

    fun getLink(): LiveData<String> = link
}