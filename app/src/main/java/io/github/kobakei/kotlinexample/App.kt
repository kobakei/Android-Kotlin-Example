package io.github.kobakei.kotlinexample

import android.app.Application
import io.github.kobakei.kotlinexample.di.AppComponent
import io.github.kobakei.kotlinexample.di.AppModule
import io.github.kobakei.kotlinexample.di.DaggerAppComponent

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
class App: Application() {

    lateinit var injector: AppComponent

    override fun onCreate() {
        super.onCreate()

        injector = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}