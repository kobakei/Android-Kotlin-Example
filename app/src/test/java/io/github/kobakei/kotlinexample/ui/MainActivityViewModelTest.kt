package io.github.kobakei.kotlinexample.ui

import io.github.kobakei.kotlinexample.BuildConfig
import io.github.kobakei.kotlinexample.model.entity.User
import io.github.kobakei.kotlinexample.model.repository.UserRepository
import io.github.kobakei.kotlinexample.ui.main.MainViewModel
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config



/**
 * ViewModel test
 * Created by keisukekobayashi on 2017/04/24.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,
        sdk = intArrayOf(21))
class MainActivityViewModelTest {

    @Before
    fun setup() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    fun teardown() {
        RxJavaPlugins.reset()
    }

    @Test
    fun onResume_isCorrect() {
        val users = listOf<User>(
                User(1, "user1", "http://example.com/image"),
                User(2, "user2", "http://example.com/image"),
                User(3, "user3", "http://example.com/image"))
        val userRepository = Mockito.mock(UserRepository::class.java)
        given(userRepository.findContributorsByRepo("DroidKaigi", "conference-app-2017"))
                .willReturn(Single.just(users))

        val viewModel = MainViewModel(userRepository)

        viewModel.onResume()

        Assert.assertNotNull(viewModel.users)
        Assert.assertEquals(3, viewModel.users.size)
    }

}