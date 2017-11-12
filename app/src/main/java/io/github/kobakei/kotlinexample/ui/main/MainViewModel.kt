package io.github.kobakei.kotlinexample.ui.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.github.kobakei.kotlinexample.di.scope.PerActivity
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.model.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * メイン画面のビューモデル
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
class MainViewModel
@Inject constructor(
        private val lifecycle: Lifecycle,
        private val userRepository: UserRepository
) : ViewModel(), LifecycleObserver {

    val users: ObservableList<User> = ObservableArrayList()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        val owner = "DroidKaigi"
        val repo = "conference-app-2017"
        userRepository.findContributorsByRepo(owner, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .to(AutoDispose.with(AndroidLifecycleScopeProvider.from(lifecycle)).forSingle())
                .subscribe({
                    Timber.v("Count: ${it.size}")
                    users.clear()
                    users.addAll(it)
                }, {
                    Timber.e(it)
                })
    }
}