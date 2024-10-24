package dev.erenmalkoc.cite.preview

import dev.erenmalkoc.cite.CiteViewModel

class PreviewViewBinding(private val viewModel : CiteViewModel) {
    val adapter = PreviewAdapter(viewModel)
    val itemDecoration = PreviewDecoration()

}