package com.example.radarpop.data.template.modele

import com.google.gson.annotations.SerializedName


data class Ghibli(
        //modele de la réponse de l'api que j'utilise dans l'ensemble de l'application

        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String

)