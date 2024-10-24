package dev.erenmalkoc.cite

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.erenmalkoc.cite.preview.Preview
import dev.erenmalkoc.cite.preview.previewList

class CiteViewModel : ViewModel() {

    val cite = MutableLiveData("")
    val author = MutableLiveData("")
    val book = MutableLiveData("")
    val previews = MutableLiveData(previewList)

    fun onIntentWithTextExtra(textExtra: String) {

        cite.value = textExtra

    }

}