package com.aditya.bsptechnopracticaltask.common.utils

import android.content.Context
import android.widget.Toast
import java.util.concurrent.TimeUnit

object Helper {
    private var toast : Toast? = null

    fun showToast(context : Context, message : String, duration : Int = Toast.LENGTH_SHORT){
        toast?.cancel()
        toast  = Toast.makeText(context, message, duration)
        toast?.show()
    }

    fun isTwoHoursAgo(timestamp: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        val diffInMillis = currentTime - timestamp
        return diffInMillis >= TimeUnit.HOURS.toMillis(2)
    }
}