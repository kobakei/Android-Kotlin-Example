package io.github.kobakei.kotlinexample.ui.detail

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import io.github.kobakei.kotlinexample.R
import io.github.kobakei.kotlinexample.databinding.DetailActivityBinding
import io.github.kobakei.kotlinexample.di.ActivityComponent
import io.github.kobakei.kotlinexample.ui.base.BaseActivity
import io.github.kobakei.kotlinexample.ui.base.DaggerFactory
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    companion object {

        const val KEY_ID = "user_id"

        fun start(activity: Activity, userId: Long) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(KEY_ID, userId)
            activity.startActivity(intent)
        }
    }

    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ビューモデルを作成
        viewModel = ViewModelProviders.of(this, DaggerFactory(this)).get(DetailViewModel::class.java)
        lifecycle.addObserver(viewModel)

        // 受け取ったパラメータをビューモデルに渡す
        val userId = intent.getLongExtra(KEY_ID, 0L)
        viewModel.userId = userId

        // レイアウト
        val binding: DetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.detail_activity)
        binding.viewModel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }
}
