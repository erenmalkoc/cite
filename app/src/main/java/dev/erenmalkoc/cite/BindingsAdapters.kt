package dev.erenmalkoc.cite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.card.MaterialCardView
import dev.erenmalkoc.cite.preview.CiteInfo


@Suppress("UNCHECKED_CAST")
@BindingAdapter("items", "adapter")
fun <T, VH : ViewHolder> RecyclerView.items(items: List<T>?, listAdapter: ListAdapter<T, VH>?) {
    if (items == null || listAdapter == null) return
    if (adapter == null)
        adapter = listAdapter

    (adapter as ListAdapter<T, VH>).submitList(items)
}

@BindingAdapter("itemDecoration")
fun RecyclerView.itemDecoration(itemDecoration: ItemDecoration?) {

    if (itemDecoration == null) return
    if (itemDecorationCount == 0) addItemDecoration(itemDecoration)
}


//TODO: THIS INFLATES AND FINDS VIEWS WITH EVERY BIND OPERATION. THIS IS NOT GOOD PRACTISE. FIX LATER!
@BindingAdapter("layoutId", "viewModel")
fun ViewGroup.childView(@LayoutRes layoutId: Int, citeInfo: CiteInfo) {
    /*    if (childCount == 0) {

            val view = LayoutInflater.from(context).inflate(layoutId, this, true)
            findViewById<TextView>(R.id.citeText).text = citeInfo.cite
            findViewById<TextView>(R.id.bookText).text = citeInfo.book
            findViewById<TextView>(R.id.authorText).text = citeInfo.author
            //TODO: THIS CODE IS BROKEN

            //TODO: CHECK INFLATE USAGE AGAIN AND ATTACH TO ROOT PARAMETER!!!


        }*/

    if (childCount != 0) removeAllViews()
    val view = LayoutInflater.from(context).inflate(layoutId, this, true)
    findViewById<TextView>(R.id.citeText).text = citeInfo.cite
    findViewById<TextView>(R.id.bookText).text = citeInfo.book
    findViewById<TextView>(R.id.authorText).text = citeInfo.author

}


@BindingAdapter("strokeWidthRes")
fun MaterialCardView.strokeWidthRes(@DimenRes widthRes: Int) {

    strokeWidth = resources.getDimensionPixelSize(widthRes)


}
