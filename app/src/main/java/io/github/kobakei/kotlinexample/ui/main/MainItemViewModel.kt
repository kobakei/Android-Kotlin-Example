package io.github.kobakei.kotlinexample.ui.main

import android.app.Activity
import android.content.Intent
import android.databinding.ObservableField
import android.view.View
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.ui.base.ViewModel
import javax.inject.Inject

/**
 * Created by keisukekobayashi on 2017/04/14.
 */
class MainItemViewModel @Inject constructor(private val activity: Activity): ViewModel() {
    val user: ObservableField<User> = ObservableField()

    fun onItemClick(view: View) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }
}