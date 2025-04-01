package com.aditya.bsptechnopracticaltask.common.utils

import org.junit.Assert.*

import org.junit.Test
import java.util.concurrent.TimeUnit

class HelperTest {

    @Test
    fun isTwoHoursAgoTrue() {
        //Arrange
        val currentTime = System.currentTimeMillis()
        val hourAgo = currentTime - TimeUnit.HOURS.toMillis(2)
        //Act
        val result = Helper.isTwoHoursAgo(hourAgo)
        //Assert
        assertTrue(result)
    }

    @Test
    fun isTwoHoursAgoFalse() {
        //Arrange
        val currentTime = System.currentTimeMillis()
        val hourAgo = currentTime - TimeUnit.HOURS.toMillis(1)
        //Act
        val result = Helper.isTwoHoursAgo(hourAgo)
        //Assert
        assertFalse(result)
    }
}