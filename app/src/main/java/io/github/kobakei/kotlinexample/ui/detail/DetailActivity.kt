package io.github.kobakei.kotlinexample.ui.detail

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import io.github.kobakei.kotlinexample.R
import io.github.kobakei.kotlinexample.databinding.DetailActivityBinding
import io.github.kobakei.kotlinexample.ui.base.BaseActivity
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: DetailActivityViewModel

    companion object {

        const val KEY_ID = "user_id"

        fun start(activity: Activity, userId: Long) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(KEY_ID, userId)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injector.inject(this)
        bindViewModel(viewModel)

        val userId = intent.getLongExtra(KEY_ID, 0L)
        viewModel.userId = userId

        val binding: DetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.detail_activity)
        binding.viewModel = viewModel
    }
}
