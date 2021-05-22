package com.example.radarpop.data.template

import com.example.radarpop.data.template.apibook.GhibliApi
import com.example.radarpop.data.template.GhibliApp.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singleton {
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024 ) //10 MiB

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val filmApi: GhibliApi = Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(GhibliApi::class.java)

    }
}

/**
 * https://ghibliapi.herokuapp.com/films
 *
 *
 * https://api.thecatapi.com/v1/breeds?api_key=ee16cd75-db72-4fee-b1d5-82016622890f
 *https://api.thecatapi.com/v1/images/search?breed_ids={breed-id}?api_key=ee16cd75-db72-4fee-b1d5-82016622890f
 *
 *
 * */