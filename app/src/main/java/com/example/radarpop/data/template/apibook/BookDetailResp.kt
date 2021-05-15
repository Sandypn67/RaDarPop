package com.example.radarpop.data.template.apibook

data class BookDetailResp(
    val name: String,
    val types : List<BookSlot>
)

data class BookSlot(
    val slot: Int,
    val type: BookType
)

data class BookType(
    val name :String,
    val url : String
)