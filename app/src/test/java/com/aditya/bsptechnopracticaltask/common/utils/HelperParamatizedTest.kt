package com.aditya.bsptechnopracticaltask.common.utils

import androidx.datastore.preferences.protobuf.Timestamp
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import java.util.concurrent.TimeUnit

@RunWith(Parameterized::class)
class HelperParameterizedTest(private val input: Long, private val expected: Boolean) {

    @Test
    fun isTwoHoursAgo() {
        //Act
        val result = Helper.isTwoHoursAgo(input)
        //assert
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic  // this annotation is required to make the method static
        @Parameterized.Parameters(name = "{index}: isTwoHoursAgo({0})={1}") // name is optional
        fun data(): List<Array<Any>> {
            val currentTimestamp = System.currentTimeMillis()
            return listOf(
                arrayOf(currentTimestamp - TimeUnit.HOURS.toMillis(1) , false) ,
                arrayOf(currentTimestamp - TimeUnit.HOURS.toMillis(2) , true) ,
                arrayOf(currentTimestamp - TimeUnit.HOURS.toMillis(3) , true) ,
                arrayOf(currentTimestamp - TimeUnit.HOURS.toMillis(4) , true) ,
            )
        }
    }
}