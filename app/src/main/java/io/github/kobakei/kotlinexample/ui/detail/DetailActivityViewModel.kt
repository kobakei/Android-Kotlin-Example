package io.github.kobakei.kotlinexample.ui.detail

import android.databinding.ObservableField
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
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
class DetailActivityViewModel
@Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val user: ObservableField<User> = ObservableField()

    var userId: Long = 0L

    override fun onResume() {
        super.onResume()

        val disposable = userRepository.findUserById(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            user.set(it)
                        },
                        onError = {
                            Timber.e(it)
                        }
                )
        compositeDisposable.add(disposable)
    }

}