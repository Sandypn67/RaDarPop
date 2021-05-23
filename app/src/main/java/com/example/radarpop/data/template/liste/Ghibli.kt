package com.example.radarpop.data.template.liste

import com.google.gson.annotations.SerializedName


data class Ghibli(

        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("release_date")
        var releaseDate: String,

        @SerializedName("director")
        val director: String

)