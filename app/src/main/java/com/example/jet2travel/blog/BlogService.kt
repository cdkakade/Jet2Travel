package com.example.jet2travel.blog

import com.example.jet2travel.db.BlogEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogService {
    @GET("blogs")
    suspend fun getBlogs(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<BlogEntity>>
}