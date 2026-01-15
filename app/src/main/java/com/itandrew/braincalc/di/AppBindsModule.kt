package com.itandrew.braincalc.di

import android.content.Context
import androidx.room.Room
import com.itandrew.braincalc.MyApplication
import com.itandrew.braincalc.data.local.db.LevelsDAO
import com.itandrew.braincalc.data.local.db.LevelsDatabase
import com.itandrew.braincalc.data.remote.LevelRepository
import com.itandrew.braincalc.data.remote.LevelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
interface AppBindsModule {

    @Binds
    fun bindLevelRepository(levelRepositoryImpl: LevelRepositoryImpl): LevelRepository

    companion object {

        @Provides
        fun provideContext(app: MyApplication) : Context = app.applicationContext

        @Provides
        @Singleton
        fun provideDb(context: Context) : LevelsDatabase =
            Room.databaseBuilder(
                context,
                LevelsDatabase::class.java,
                "tasks.db"
            ).build()

        @Provides
        @Singleton
        fun provideTasksDAO(db: LevelsDatabase): LevelsDAO =
            db.levelsDao
    }
}