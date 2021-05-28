package com.example.radarpop.data.template

import android.app.Application
import android.content.Context

class GhibliApp : Application() {

    //crée une variable statique
    companion object{
        var context : Context?= null
    }
    //crée l'application d'apres le contexte statique
    override fun onCreate() {
        super.onCreate()
        context =this
    }
}