package dev.erenmalkoc.cite

import dev.erenmalkoc.cite.preview.CiteInfo

fun CiteInfo.from(viewModel: CiteViewModel) = CiteInfo(
    cite = viewModel.cite.value!!,
    author = viewModel.author.value!!,
    book = viewModel.book.value!!
)


//TODO:39:21 / 1:16:10