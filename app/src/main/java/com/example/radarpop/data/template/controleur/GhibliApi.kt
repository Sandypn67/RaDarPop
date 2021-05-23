package com.example.radarpop.data.template.controleur

import retrofit2.Call
import retrofit2.http.GET

interface GhibliApi {
    @GET("films")
    fun getGhibliList(): Call<List<GhibliListResp>>
}