package com.example.jet2travel.di

import android.content.Context
import androidx.room.Room
import com.example.jet2travel.DATABASE_NAME
import com.example.jet2travel.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Context): AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideBlogDao(appDatabase: AppDatabase) = appDatabase.blogDao()

    @Provides
    @Singleton
    fun provideRemoteDao(appDatabase: AppDatabase) = appDatabase.remoteKeysDao()
}