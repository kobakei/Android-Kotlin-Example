package io.github.kobakei.kotlinexample

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by keisukekobayashi on 2017/04/24.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class ExampleRobolectricTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        Assert.assertEquals(4, (2 + 2).toLong())
    }
}