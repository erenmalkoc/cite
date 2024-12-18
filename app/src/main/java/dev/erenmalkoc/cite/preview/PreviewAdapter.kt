package dev.erenmalkoc.cite.preview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.erenmalkoc.cite.R
import dev.erenmalkoc.cite.databinding.ItemPreviewBinding

class PreviewAdapter(private val citeInfo: CiteInfo,
    private val listener : PreviewItemClickListener
    ) :
    ListAdapter<Preview, PreviewAdapter.PreviewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewHolder {

        val binding: ItemPreviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_preview,
            parent,
            false
        )

        return PreviewHolder(binding,citeInfo,listener)
    }

    override fun onBindViewHolder(holder: PreviewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class PreviewHolder(
        private val binding: ItemPreviewBinding,
        private val citeInfo: CiteInfo,
        private val listener: PreviewItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(preview: Preview) {
            binding.item = preview
            binding.citeInfo=citeInfo
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

    interface PreviewItemClickListener {
fun onItemClick(preview : Preview)
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Preview>() {
            override fun areItemsTheSame(oldItem: Preview, newItem: Preview): Boolean =
                oldItem.layoutId == newItem.layoutId


            override fun areContentsTheSame(oldItem: Preview, newItem: Preview): Boolean =
                oldItem == newItem


        }
    }


}