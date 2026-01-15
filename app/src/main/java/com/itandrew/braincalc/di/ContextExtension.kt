package com.itandrew.braincalc.di

import android.content.Context
import com.itandrew.braincalc.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }