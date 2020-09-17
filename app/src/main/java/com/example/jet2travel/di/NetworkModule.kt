package com.example.jet2travel.di

import android.util.Log
import com.example.jet2travel.API_ENDPOINT
import com.example.jet2travel.TAG
import com.example.jet2travel.blog.BlogApiClient
import com.example.jet2travel.blog.BlogService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.i("Jet2Travel","OkHttpClient hashcode: ${okHttpClient.hashCode()}")
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_ENDPOINT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    @Provides
    fun provideService(retrofit: Retrofit): BlogService {
        Log.i(TAG,"Retrofit hashcode: ${retrofit.hashCode()}")
        return retrofit.create(BlogService::class.java)
    }

    @Singleton
    @Provides
    fun provideBlogApiClient(blogService: BlogService) =
        BlogApiClient(blogService)
}