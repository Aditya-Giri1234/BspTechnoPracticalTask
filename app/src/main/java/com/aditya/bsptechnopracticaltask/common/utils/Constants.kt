package com.aditya.bsptechnopracticaltask.common.utils

object Constants {
    const val BASE_URL = "https://practical.mytdigital.tech/"
    const val TEST_DISCOVERY = "testdiscovery"

    //Testing Tag
    const val PULL_TO_REFRESH = "pull_to_refresh"
    const val OUTER_LAZY_COLUMN = "outer_lazy_column"
}

enum class ElementType(val elementType : String){
    BANNER("banner"),
    CAROUSEL("carousel"),
    CLASSIC("classic"),
    FEATURED("featured"),
    GROUP_CONTENT("group_content")
}