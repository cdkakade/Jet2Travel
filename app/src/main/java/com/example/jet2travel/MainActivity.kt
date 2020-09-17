package com.example.jet2travel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jet2travel.blog.BlogAdapter
import com.example.jet2travel.blog.BlogViewModel
import com.example.jet2travel.databinding.ActivityMainBinding
import com.example.jet2travel.db.Result
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var blogViewModel: BlogViewModel

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

    private fun subscribeUi(adapter: BlogAdapter) {
        blogViewModel.getBlogs().observe(this, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    //binding.progressBar.hide()
                    result.data?.let { adapter.submitList(it) }
                }
                Result.Status.LOADING -> {
                }
                Result.Status.ERROR -> {
                    //binding.progressBar.hide()
                    //Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}