package com.itandrew.braincalc

import android.app.Application
import com.itandrew.braincalc.di.AppComponent
import com.itandrew.braincalc.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var AppComponent : AppComponent
        private set

    override fun onCreate(){
        super.onCreate()
        AppComponent = DaggerAppComponent
            .create()
    }
}