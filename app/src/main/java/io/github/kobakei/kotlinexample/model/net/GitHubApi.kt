package io.github.kobakei.kotlinexample.model.net

import io.github.kobakei.kotlinexample.model.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * GitHub API
 * Created by keisukekobayashi on 2017/04/14.
 */
interface GitHubApi {

    @GET("/repos/{owner}/{repo}/contributors")
    fun listContributors(@Path("owner") owner: String,
                         @Path("repo") repo: String): Single<List<User>>
}