package com.dph.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.dph.android.hilt.data.AppDb
import com.dph.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext appContext: Context): AppDb {
        return Room.databaseBuilder(appContext, AppDb::class.java, "logging.db").build()
    }

    @Provides
    fun provideLogDao(db: AppDb): LogDao {
        return db.logDao()
    }
}