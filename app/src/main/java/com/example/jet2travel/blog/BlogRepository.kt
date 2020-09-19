package com.example.jet2travel.blog

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jet2travel.db.AppDatabase
import com.example.jet2travel.db.BlogEntity
import com.example.jet2travel.paging.BlogRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BlogRepository @Inject constructor(
    private val service: BlogService,
    private val database: AppDatabase
) {
    fun getBlogs(): Flow<PagingData<BlogEntity>> {
        val pagingSourceFactory = { database.blogDao().getAll() }

        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = BlogRemoteMediator(
                service,
                database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }
}