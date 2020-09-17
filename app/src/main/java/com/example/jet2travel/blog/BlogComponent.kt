package com.example.jet2travel.blog

import com.example.jet2travel.MainActivity
import dagger.Subcomponent

@Subcomponent
interface BlogComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): BlogComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)

}