package com.example.radarpop.data.template

import android.app.Application
import android.content.Context

class GhibliApp : Application() {
    companion object{
        var context : Context?= null
    }
    override fun onCreate() {
        super.onCreate()
        context =this
    }
}