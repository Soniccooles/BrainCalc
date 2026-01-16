package com.itandrew.braincalc.di

import com.itandrew.braincalc.di.viewModel.ViewModelModule
import com.itandrew.braincalc.presenter.MainFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
    ])
class AppModule