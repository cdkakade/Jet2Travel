package com.example.jet2travel.blog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jet2travel.db.BlogEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BlogViewModel@Inject constructor(private val repository: BlogRepository):ViewModel() {

    fun getBlogs(): Flow<PagingData<BlogEntity>> {
        return repository.getBlogs()
            .cachedIn(viewModelScope)
    }
}