package com.bc0098.agritivity.utils

import androidx.test.espresso.idling.CountingIdlingResource

object IdlingResource {

    private const val resource = "GLOBAL"
    val idlingResource = CountingIdlingResource(resource)

    fun increment(){
        idlingResource.increment()
    }

    fun decrement(){
        idlingResource.decrement()
    }
}