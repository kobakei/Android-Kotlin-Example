package io.github.kobakei.kotlinexample.ui.main

import io.github.kobakei.kotlinexample.di.scope.PerActivity
import io.github.kobakei.kotlinexample.model.repository.UserRepository
import javax.inject.Inject

/**
 * メイン画面のビューモデル
 * Created by keisukekobayashi on 2017/04/14.
 */
@PerActivity
class MainActivityViewModel
@Inject constructor(private val userRepository: UserRepository) {

}