package com.example.radarpop.data.template.liste

import android.app.Application
import android.content.Context

class BookApp : Application() {
    companion object{
        var context : Context?= null
    }
    override fun onCreate() {
        super.onCreate()
        context =this
    }
}