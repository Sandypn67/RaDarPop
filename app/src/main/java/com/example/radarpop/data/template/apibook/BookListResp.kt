package com.example.radarpop.data.template.apibook

import com.example.radarpop.data.template.liste.Book

data class BookListResp (
    val count :Int,
    val next: String,
    val results : List<Book>
)