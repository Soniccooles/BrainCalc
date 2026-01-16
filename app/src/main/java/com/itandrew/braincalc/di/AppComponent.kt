package com.itandrew.braincalc.di

import com.itandrew.braincalc.MyApplication
import com.itandrew.braincalc.di.viewModel.ViewModelModule
import com.itandrew.braincalc.presenter.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MyApplication): AppComponent
    }

    fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
    ])
class AppModule