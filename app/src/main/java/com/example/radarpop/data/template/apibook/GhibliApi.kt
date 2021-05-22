package com.example.radarpop.data.template.apibook

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GhibliApi {
    @GET("films")
    fun getGhibliList(): Call<List<GhibliListResp>>
    //@Query("key") key:String
   //@GET("films/{description}")
   //fun getGhibliDetail(@Path("description") description:String): Call<GhibliDetailResp>
}