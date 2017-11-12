package io.github.kobakei.kotlinexample.di

import dagger.Subcomponent
import io.github.kobakei.kotlinexample.di.scope.PerActivity
import io.github.kobakei.kotlinexample.ui.detail.DetailActivity
import io.github.kobakei.kotlinexample.ui.detail.DetailViewModel
import io.github.kobakei.kotlinexample.ui.main.MainActivity
import io.github.kobakei.kotlinexample.ui.main.MainItemViewModel
import io.github.kobakei.kotlinexample.ui.main.MainViewModel

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun mainViewModel(): MainViewModel
    fun detailViewModel(): DetailViewModel

    fun mainItemViewModel(): MainItemViewModel
}