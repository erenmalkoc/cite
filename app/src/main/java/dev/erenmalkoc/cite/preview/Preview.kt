package dev.erenmalkoc.cite.preview

import androidx.annotation.LayoutRes
import dev.erenmalkoc.cite.R

data class Preview(
@LayoutRes val layoutId : Int,
 val isSelected: Boolean = false
) {

    val strokeWidth = when {
        isSelected ->
            R.dimen.card_stroke_width

        else ->
            R.dimen.zero
    }

}