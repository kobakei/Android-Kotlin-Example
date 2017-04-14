package io.github.kobakei.kotlinexample.di

import android.app.Activity
import dagger.Module
import dagger.Provides
import io.github.kobakei.kotlinexample.di.scope.PerActivity

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

}