package com.pguptafeb.ecommercedemo.constants

import java.util.*


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
enum class AppColorPatch(val appColor: String, val colorHex: String) {
    RED("red", "#ff0000"),
    SILVER("silver", "#D0D2D1"),
    BLUE("blue", "#0000FF"),
    GREEN("green", "#008000"),
    WHITE("white", "#FFFFFF")
}

fun String.getAppColorPatchInHex(): String {
    return AppColorPatch.values().find { it.appColor == toLowerCase(Locale.US) }?.colorHex
        ?: "#FFFFFF"
}