package com.example.jet2travel.blog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jet2travel.databinding.ListItemBlogBinding
import com.example.jet2travel.db.BlogEntity

class BlogAdapter : ListAdapter<BlogEntity, RecyclerView.ViewHolder>(
    BlogDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlantViewHolder(
            ListItemBlogBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    class PlantViewHolder(
        private val binding: ListItemBlogBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BlogEntity) {
            binding.apply {
                blog = item
                executePendingBindings()
            }
        }
    }
}

private class BlogDiffCallback : DiffUtil.ItemCallback<BlogEntity>() {

    override fun areItemsTheSame(oldItem: BlogEntity, newItem: BlogEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BlogEntity, newItem: BlogEntity): Boolean {
        return oldItem == newItem
    }
}