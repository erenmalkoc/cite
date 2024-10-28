package dev.erenmalkoc.cite.preview

import dev.erenmalkoc.cite.CiteViewModel

class PreviewViewBinding(viewModel: CiteViewModel) {
    val adapter = PreviewAdapter(
        citeInfo = CiteInfo(
            cite = viewModel.cite.value!!,
            author = viewModel.author.value!!,
            book = viewModel.book.value!!

        ),
        listener = viewModel
    )
    val itemDecoration = PreviewDecoration()

}