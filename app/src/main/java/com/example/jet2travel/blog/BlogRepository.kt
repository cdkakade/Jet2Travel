package com.example.jet2travel.blog

import com.example.jet2travel.db.BlogDao
import com.example.jet2travel.db.getLiveData
import javax.inject.Inject

class BlogRepository @Inject constructor(
    private val productApi: BlogApiClient,
    private val productDb: BlogDao
) {

    fun getBlogs() = getLiveData(
        databaseQuery = { productDb.getAll() },
        networkCall = { productApi.fetchData() },
        saveCallResult = { productDb.insertAll(it) })
}