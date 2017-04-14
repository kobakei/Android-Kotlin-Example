package io.github.kobakei.kotlinexample.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import io.github.kobakei.kotlinexample.R
import io.github.kobakei.kotlinexample.databinding.MainActivityBinding
import io.github.kobakei.kotlinexample.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injector.inject(this)

        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
    }
}
