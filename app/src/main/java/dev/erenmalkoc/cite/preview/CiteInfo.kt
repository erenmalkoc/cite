package dev.erenmalkoc.cite.preview

import dev.erenmalkoc.cite.CiteViewModel

data class CiteInfo(
    val cite: String,
    val book: String,
    val author: String


) {
    companion object {
        fun from(viewModel: CiteViewModel) = CiteInfo(
            cite = viewModel.cite.value!!,
            author = viewModel.author.value!!,
            book = viewModel.book.value!!
        )
    }
}

