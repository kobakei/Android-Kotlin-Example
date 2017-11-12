package io.github.kobakei.kotlinexample.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.github.kobakei.kotlinexample.ui.detail.DetailActivity
import io.github.kobakei.kotlinexample.ui.main.MainActivity

/**
 * ビューモデルを作成するファクトリ
 * Daggerから生成します
 *
 * Created by keisuke on 2017/11/12.
 */
class DaggerFactory(private val activity: BaseActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (activity.javaClass.simpleName) {
            MainActivity::class.java.simpleName -> activity.injector.mainViewModel() as T
            DetailActivity::class.java.simpleName -> activity.injector.detailViewModel() as T
            else -> throw IllegalArgumentException()
        }
    }
}