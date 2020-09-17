package com.example.jet2travel

import android.app.Application
import android.util.Log
import com.example.jet2travel.di.AppComponent
import com.example.jet2travel.di.DaggerAppComponent

open class App : Application() {
    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        Log.i("Jet2Travel","initialing app component")
        DaggerAppComponent.factory().create(applicationContext)
    }
}