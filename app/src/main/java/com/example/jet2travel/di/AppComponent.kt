package com.example.jet2travel.di

import android.content.Context
import com.example.jet2travel.blog.BlogComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        ViewModelFactoryModule::class,
        AppSubcomponents::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun blogComponent(): BlogComponent.Factory
}