package io.github.kobakei.kotlinexample.model.repository

import io.github.kobakei.kotlinexample.model.dao.UserDao
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.model.net.GitHubApi
import io.reactivex.Single
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

    /**
     * 指定のユーザー／リポジトリのコントリビュータを取得する
     */
    fun findContributorsByRepo(owner: String, repo: String): Single<List<User>> {
        return gitHubApi.listContributors(owner, repo)
    }

    /**
     * 指定のIDのユーザーを取得する
     */
    fun findUserById(userId: Long) {
        TODO()
    }

}