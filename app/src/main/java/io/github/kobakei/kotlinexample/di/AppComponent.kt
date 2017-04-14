package io.github.kobakei.kotlinexample.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

}