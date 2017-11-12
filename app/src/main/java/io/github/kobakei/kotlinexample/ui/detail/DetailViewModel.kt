package io.github.kobakei.kotlinexample.ui.detail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
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
 * 詳細画面のビューモデル
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
class DetailViewModel
@Inject constructor(
        private val userRepository: UserRepository
) : ViewModel(), LifecycleObserver {

    lateinit var lifecycle: Lifecycle

    val user: ObservableField<User> = ObservableField()

    var userId: Long = 0L

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        userRepository.findUserById(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .to(AutoDispose.with(AndroidLifecycleScopeProvider.from(lifecycle)).forSingle())
                .subscribe({
                    user.set(it)
                }, {
                    Timber.e(it)
                })
    }

}