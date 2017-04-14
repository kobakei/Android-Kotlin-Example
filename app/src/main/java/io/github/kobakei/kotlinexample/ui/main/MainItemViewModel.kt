package io.github.kobakei.kotlinexample.ui.main

import android.databinding.ObservableField
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.ui.base.ViewModel
import javax.inject.Inject

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
class MainItemViewModel @Inject constructor(): ViewModel() {
    val user: ObservableField<User> = ObservableField()
}