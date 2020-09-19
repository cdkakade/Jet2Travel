package com.example.jet2travel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jet2travel.blog.BlogAdapter
import com.example.jet2travel.blog.BlogViewModel
import com.example.jet2travel.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var blogViewModel: BlogViewModel

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.blogComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setTitle(R.string.title)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = BlogAdapter()
        val horizontalLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.blogList.layoutManager = horizontalLayoutManager
        binding.blogList.adapter = adapter
        subscribeUi(adapter)
    }

    @ExperimentalCoroutinesApi
    private fun subscribeUi(adapter: BlogAdapter) {
        lifecycleScope.launch {
            blogViewModel.getBlogs().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}