package com.itandrew.braincalc.di

import android.content.Context
import androidx.room.Room
import com.itandrew.braincalc.MyApplication
import com.itandrew.braincalc.data.local.db.LevelsDAO
import com.itandrew.braincalc.data.local.db.LevelsDatabase
import com.itandrew.braincalc.data.local.repository.LevelsRepository
import com.itandrew.braincalc.data.local.repository.LevelsRepositoryImpl
import com.itandrew.braincalc.data.remote.ApiRepository
import com.itandrew.braincalc.data.remote.ApiRepositoryImpl
import com.itandrew.braincalc.domain.DownloadLevelsUseCase
import com.itandrew.braincalc.domain.DownloadLevelsUseCaseImpl
import com.itandrew.braincalc.domain.GetAllLevelIdsUseCase
import com.itandrew.braincalc.domain.GetAllLevelIdsUseCaseImpl
import com.itandrew.braincalc.domain.GetLevelByIdUseCase
import com.itandrew.braincalc.domain.GetLevelByIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
interface AppBindsModule {

    @Binds
    fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository

    @Binds
    fun bindLevelsRepository(levelsRepositoryImpl: LevelsRepositoryImpl): LevelsRepository

    @Binds
    fun bindDownloadLevelsUseCase(downloadLevelsUseCaseImpl: DownloadLevelsUseCaseImpl): DownloadLevelsUseCase

    @Binds
    fun bindGetAllLevelIdsUseCase(getAllLevelIdsUseCaseImpl: GetAllLevelIdsUseCaseImpl): GetAllLevelIdsUseCase

    @Binds
    fun bundGetLevelByIdUseCase(getLevelByIdUseCaseImpl: GetLevelByIdUseCaseImpl): GetLevelByIdUseCase

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