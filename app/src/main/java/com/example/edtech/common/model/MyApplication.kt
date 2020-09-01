package com.example.edtech.common.model

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class MyApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        Stetho.initializeWithDefaults(this)
    }
}