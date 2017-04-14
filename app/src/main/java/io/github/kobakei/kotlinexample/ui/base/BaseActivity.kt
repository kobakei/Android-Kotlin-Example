package io.github.kobakei.kotlinexample.ui.base

import android.support.v7.app.AppCompatActivity
import io.github.kobakei.kotlinexample.App
import io.github.kobakei.kotlinexample.di.ActivityComponent
import io.github.kobakei.kotlinexample.di.ActivityModule
import java.util.ArrayList

/**
 * Created by keisukekobayashi on 2017/04/14.
 */

open class BaseActivity: AppCompatActivity() {

    val viewModels: ArrayList<ViewModel> = arrayListOf()

    val injector: ActivityComponent
        get() {
            val app = applicationContext as App
            return app.injector.activityComponent(ActivityModule(this))
        }

    protected fun bindViewModel(viewModel: ViewModel) {
        viewModels.add(viewModel)
    }

    override fun onResume() {
        super.onResume()
        viewModels.forEach { it.onResume() }
    }

    override fun onPause() {
        super.onPause()
        viewModels.forEach { it.onPause() }
    }
}