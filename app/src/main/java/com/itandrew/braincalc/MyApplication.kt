package com.itandrew.braincalc

import android.app.Application
import com.itandrew.braincalc.di.AppComponent
import com.itandrew.braincalc.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }

}