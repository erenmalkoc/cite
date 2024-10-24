package dev.erenmalkoc.cite.preview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.erenmalkoc.cite.R

class PreviewDecoration : RecyclerView.ItemDecoration()  {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
       val spacing =   view.resources.getDimensionPixelSize(R.dimen.preview_item_spacing)
        val isFirstItem = parent.getChildAdapterPosition(view) ==0
        if(isFirstItem) outRect.top = spacing

        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing


    }


}