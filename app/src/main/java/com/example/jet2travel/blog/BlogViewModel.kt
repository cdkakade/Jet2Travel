package com.example.jet2travel.blog

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jet2travel.db.BlogEntity
import com.example.jet2travel.db.Result
import javax.inject.Inject

class BlogViewModel@Inject constructor(private val blogRepository: BlogRepository):ViewModel() {

    fun getBlogs(): LiveData<Result<List<BlogEntity>>> {
        return blogRepository.getBlogs()
    }
}