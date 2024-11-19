package dev.erenmalkoc.cite.preview

import dev.erenmalkoc.cite.CiteViewModel

class PreviewViewBinding(viewModel: CiteViewModel) {
    val adapter = PreviewAdapter(
        citeInfo = viewModel.citeInfo,
        listener = viewModel
    )
    val itemDecoration = PreviewDecoration()

}