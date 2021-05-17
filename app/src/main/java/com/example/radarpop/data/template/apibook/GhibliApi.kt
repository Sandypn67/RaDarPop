package com.example.radarpop.data.template.apibook

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GhibliApi {
    @GET("pokemon")
    fun getBookList(): Call<GhibliListResp>

    @GET("pokemon/{id}")
    fun getBookDetail(@Path("id") id:Int): Call<BookDetailResp>
}