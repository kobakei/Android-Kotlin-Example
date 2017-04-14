package io.github.kobakei.kotlinexample.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.github.kobakei.kotlinexample.App
import io.github.kobakei.kotlinexample.model.net.GitHubApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger module for app scope
 * アプリケーション全体で使いまわすインスタンスを提供する
 *
 * Created by keisukekobayashi on 2017/04/14.
 */
@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideGitHubApi(gson: Gson, client: OkHttpClient): GitHubApi {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl("https://api.github.com/")
                .build()
        return retrofit.create(GitHubApi::class.java)
    }

}