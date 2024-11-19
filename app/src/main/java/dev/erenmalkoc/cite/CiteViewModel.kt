package dev.erenmalkoc.cite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.erenmalkoc.cite.preview.CiteInfo
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

    var selectedPreview = previews.value!![0]

    val citeInfo
        get() = CiteInfo(
            cite = cite.value!!,
            author = author.value!!,
            book = book.value!!
        )

    fun onIntentWithTextExtra(textExtra: String) {

        cite.value = textExtra

    }

    fun onClipboardText(copiedText : String) {
cite.value = copiedText
    }

    override fun onItemClick(preview: Preview) {
        previews.value = previews.value!!.map {
            if (it.layoutId == preview.layoutId) {
                preview.copy(isSelected = true)
            } else {
                it.copy(isSelected = false)
            }
        }
selectedPreview = preview

    }

    fun onShareCiteButtonClick() {
// 1) Get a bitmap out of view hierarchy.


// 2) Save the bitmap as s png file in temp directory.
// 3) Share the url of the file with system dialog.


    }


}