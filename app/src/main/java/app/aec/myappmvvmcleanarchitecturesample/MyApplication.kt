package app.aec.myappmvvmcleanarchitecturesample

import android.app.Application
import app.aec.myappmvvmcleanarchitecturesample.di.AppComponent
import app.aec.myappmvvmcleanarchitecturesample.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}