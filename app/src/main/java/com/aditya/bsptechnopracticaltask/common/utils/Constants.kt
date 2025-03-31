package com.aditya.bsptechnopracticaltask.common.utils

object Constants {
    const val BASE_URL = "https://practical.mytdigital.tech/"
    const val TEST_DISCOVERY = "testdiscovery"
}

enum class ElementType(val elementType : String){
    BANNER("banner"),
    CAROUSEL("carousel"),
    CLASSIC("classic"),
    FEATURED("featured"),
    GROUP_CONTENT("group_content")
}