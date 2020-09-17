package com.example.jet2travel.di

import com.example.jet2travel.blog.BlogComponent
import dagger.Module

@Module(
    subcomponents = [BlogComponent::class]
)
class AppSubcomponents {
}