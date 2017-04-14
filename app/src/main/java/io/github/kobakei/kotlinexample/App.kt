package io.github.kobakei.kotlinexample

import android.app.Application
import io.github.kobakei.kotlinexample.di.AppComponent
import io.github.kobakei.kotlinexample.di.AppModule
import io.github.kobakei.kotlinexample.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
class App: Application() {

    lateinit var injector: AppComponent

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        injector = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}