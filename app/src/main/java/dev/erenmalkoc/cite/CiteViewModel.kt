package dev.erenmalkoc.cite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CiteViewModel : ViewModel() {

    val state = MutableLiveData(
        CiteState()
    )

    fun onIntentWithTextExtra(textExtra: String) {

        state.update {
            copy(cite = textExtra)
        }

    }

}