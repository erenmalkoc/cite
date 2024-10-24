package dev.erenmalkoc.cite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


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


//TODO: THIS INFLATES AND FINDS VIEWS WITH EVERY BIND OPERATION. THIS IS NOT GOOD PRACTİSE. FIX LATER!
@BindingAdapter("layoutId", "viewModel")
fun ViewGroup.childView(@LayoutRes layoutId: Int, viewModel: CiteViewModel) {
    if (childCount == 0) {

        LayoutInflater.from(context).inflate(layoutId, this, true)
        findViewById<TextView>(R.id.citeText).text = viewModel.cite.value!!
        findViewById<TextView>(R.id.authorCommaBookText).text =
            viewModel.author.value!! + " , " + viewModel.book.value!!


    }
}
