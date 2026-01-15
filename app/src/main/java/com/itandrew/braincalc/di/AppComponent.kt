package com.itandrew.braincalc.di

import dagger.Component
import dagger.Module

@Component(
    modules = [AppModule::class]
)
interface AppComponent {
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
    ])
class AppModule