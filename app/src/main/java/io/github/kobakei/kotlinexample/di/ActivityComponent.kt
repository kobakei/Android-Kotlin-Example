package io.github.kobakei.kotlinexample.di

import dagger.Subcomponent
import io.github.kobakei.kotlinexample.di.scope.PerActivity
import io.github.kobakei.kotlinexample.ui.main.MainActivity

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(target: MainActivity)

}