package com.example.jet2travel.blog

import com.example.jet2travel.api.BaseDataSource
import javax.inject.Inject

class BlogApiClient @Inject constructor(private val service: BlogService) : BaseDataSource() {
    suspend fun fetchData() = getResult { service.getBlogs(1,10) }
}