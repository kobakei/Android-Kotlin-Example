package io.github.kobakei.kotlinexample.ui.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import io.github.kobakei.kotlinexample.App
import io.github.kobakei.kotlinexample.di.ActivityComponent
import io.github.kobakei.kotlinexample.di.ActivityModule
import java.util.ArrayList

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {
    val injector: ActivityComponent
        get() {
            val app = applicationContext as App
            return app.injector.activityComponent(ActivityModule(this))
        }
}