package io.github.kobakei.kotlinexample.model.repository

import io.github.kobakei.kotlinexample.model.dao.UserDao
import io.github.kobakei.kotlinexample.model.net.GitHubApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * user entityに対するリポジトリ
 * CRUDを提供します。
 *
 * このサンプルは機能が少ないので、ビューモデルから直接呼ばれますが
 * 規模の大きいアプリではビューモデルとリポジトリの間にユースケース層を挟む事が多いです
 *
 * Created by keisukekobayashi on 2017/04/14.
 */
@Singleton
class UserRepository
@Inject constructor(private val gitHubApi: GitHubApi, private val userDao: UserDao) {

    fun findContributorsByRepo(repo: String) {

    }

    fun findUserById(userId: Long) {

    }

}