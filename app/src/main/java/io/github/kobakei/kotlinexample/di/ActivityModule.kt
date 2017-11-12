package io.github.kobakei.kotlinexample.di

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import io.github.kobakei.kotlinexample.di.scope.PerActivity

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@Module
class ActivityModule(private val activity: FragmentActivity) {

    @PerActivity
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @PerActivity
    @Provides
    fun provideLifecycle(): Lifecycle {
        return activity.lifecycle
    }

}