package com.example.radarpop.data.template.apibook

data class BookListResp (
    val count :Int,
    val next: String,
    val results : List<Book>
)