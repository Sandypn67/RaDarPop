package com.example.radarpop.data.template.apibook

import com.example.radarpop.data.template.liste.Ghibli

data class GhibliListResp (
    val count :Int,
    val next: String,
    val results : List<Ghibli>
)