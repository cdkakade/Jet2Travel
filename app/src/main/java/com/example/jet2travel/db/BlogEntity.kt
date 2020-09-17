package com.example.jet2travel.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jet2travel.blog.Media
import com.example.jet2travel.blog.User
import com.google.gson.annotations.SerializedName

@Entity(tableName = "blogs")
data class BlogEntity(
    @field:SerializedName("id")
    @PrimaryKey @ColumnInfo(name = "id") var id: String = "",

    @field:SerializedName("createdAt")
    var createdAt: String = "",

    @field:SerializedName("content")
    var content: String = "",

    @field:SerializedName("comments")
    var comments: Long = 0,

    @field:SerializedName("likes")
    var likes: Long = 0,

    @field:SerializedName("media")
    var media: MutableList<Media> = arrayListOf(),

    @field:SerializedName("user")
    var user: MutableList<User> = arrayListOf()
) {
    override fun toString() = content
}