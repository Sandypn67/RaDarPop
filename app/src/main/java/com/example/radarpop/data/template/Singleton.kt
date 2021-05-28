package com.example.radarpop.data.template

import com.example.radarpop.data.template.controleur.GhibliApi
import com.example.radarpop.data.template.GhibliApp.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singleton {
    companion object{
        //met les réponses de l'api dans un cache au cas où il y ait un probleme de connexion
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024 ) //10 MiB

        //crée un client HTTP pour gagner en vitesse lors des requetes HTTP
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        //se connecte à l'API Ghibli et fait une requete au client HTTP
        val filmApi: GhibliApi = Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(GhibliApi::class.java)

    }
}
