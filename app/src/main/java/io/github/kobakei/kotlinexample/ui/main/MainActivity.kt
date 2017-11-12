package io.github.kobakei.kotlinexample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.kobakei.kotlinexample.R
import io.github.kobakei.kotlinexample.databinding.MainActivityBinding
import io.github.kobakei.kotlinexample.ui.base.BaseActivity
import io.github.kobakei.kotlinexample.ui.base.DaggerFactory

class MainActivity : BaseActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel
        viewModel = ViewModelProviders.of(this, DaggerFactory(this)).get(MainViewModel::class.java)
        lifecycle.addObserver(viewModel)

        // レイアウト
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.viewModel = viewModel

        binding.recyclerView.adapter = MainAdapter(this, injector, viewModel.users)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }
}
