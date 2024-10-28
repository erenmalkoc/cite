package dev.erenmalkoc.cite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.erenmalkoc.cite.preview.Preview
import dev.erenmalkoc.cite.preview.PreviewAdapter


class CiteViewModel : ViewModel(), PreviewAdapter.PreviewItemClickListener {

    val cite = MutableLiveData("")
    val author = MutableLiveData("")
    val book = MutableLiveData("")
    val previews = MutableLiveData(
        listOf(
            Preview(
                layoutId = R.layout.preview_1,
                isSelected = true
            ),
            Preview(
                layoutId = R.layout.preview_2,
                isSelected = true
            )


        )
    )

    fun onIntentWithTextExtra(textExtra: String) {

        cite.value = textExtra

    }

    override fun onItemClick(preview: Preview) {
        previews.value = previews.value!!.map {
            if (it.layoutId == preview.layoutId) {
                preview.copy(isSelected = true)
            } else {
                it.copy(isSelected = false)
            }
        }


    }

}