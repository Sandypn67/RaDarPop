package com.example.radarpop.data.template.modele

import com.google.gson.annotations.SerializedName


data class Ghibli(

        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String

)