package com.example.jet2travel.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BlogEntity::class, RemoteKeys::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}