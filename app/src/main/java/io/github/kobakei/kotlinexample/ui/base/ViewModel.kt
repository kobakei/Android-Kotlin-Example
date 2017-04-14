package io.github.kobakei.kotlinexample.ui.base

import android.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable

/**
 * ViewModel base class
 * This class is bound to Activity lifecycle and disposes subscriptions on pause.
 *
 * Created by keisukekobayashi on 2017/04/14.
 */
open class ViewModel: BaseObservable() {

    protected var compositeDisposable = CompositeDisposable()

    open fun onResume() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
    }

    open fun onPause() {
        compositeDisposable.dispose()
    }
}