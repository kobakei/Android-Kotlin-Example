package io.github.kobakei.kotlinexample.ui.main

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import io.github.kobakei.kotlinexample.di.scope.PerActivity
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.model.repository.UserRepository
import io.github.kobakei.kotlinexample.ui.base.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * メイン画面のビューモデル
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
class MainActivityViewModel
@Inject constructor(private val userRepository: UserRepository): ViewModel() {

    val users: ObservableList<User> = ObservableArrayList()

    override fun onResume() {
        super.onResume()

        val owner = "DroidKaigi"
        val repo = "conference-app-2017"
        val disposable = userRepository.findContributorsByRepo(owner, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            Timber.v("Count: ${it.size}")
                            users.clear()
                            users.addAll(it)
                        },
                        onError = {
                            Timber.e(it)
                        }
                )
        compositeDisposable.add(disposable)
    }

    override fun onPause() {
        super.onPause()
    }
}