package com.example.jet2travel.db

import androidx.room.TypeConverter
import com.example.jet2travel.blog.Media
import com.example.jet2travel.blog.User
import com.google.gson.Gson

class ListConverter {

    @TypeConverter
    fun mediaListToJson(value: List<Media>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMediaList(value: String) = Gson().fromJson(value, Array<Media>::class.java).toList()

    @TypeConverter
    fun userListToJson(value: List<User>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonTouserList(value: String) =
        Gson().fromJson(value, Array<User>::class.java).toList()

}