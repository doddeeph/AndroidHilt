package com.dph.android.hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Log::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun logDao() : LogDao
}