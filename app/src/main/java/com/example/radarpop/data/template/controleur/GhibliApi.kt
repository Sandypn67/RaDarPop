package com.example.radarpop.data.template.controleur

import retrofit2.Call
import retrofit2.http.GET

interface GhibliApi {
    //recupere en une liste toutes les données de "films" de l'API Ghibli
    @GET("films")
    fun getGhibliList(): Call<List<GhibliListResp>>
}