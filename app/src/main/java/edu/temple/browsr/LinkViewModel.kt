package edu.temple.browsr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LinkViewModel : ViewModel() {
    private val link = MutableLiveData<String>("https://www.google.com")

    fun setLink(url: String?) {
        var _link = url?: "";
        if(_link.matches(Regex("^[a-zA-Z0-9-]+\\\\.[a-zA-Z]{2,}\$"))) {
            _link = "https://$url"
        } else {
            _link.replace(" ", "+")
            _link = "https://duckduckgo.com/?q=$_link&t=h_&ia=web"
        }
        link.value = _link
    }

    fun getLink(): LiveData<String> = link
}