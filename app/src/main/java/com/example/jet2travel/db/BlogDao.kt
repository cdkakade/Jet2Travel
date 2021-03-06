package com.example.jet2travel.db

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface BlogDao {
    @Query("SELECT * FROM blogs")
    fun getAll(): PagingSource<Int, BlogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repositoryEntity: BlogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repositoryEntity: List<BlogEntity>)

    @Query("DELETE FROM blogs WHERE id= :deleteId")
    suspend fun delete(deleteId: String)

    @Query("DELETE FROM blogs")
    suspend fun deleteAll()
}