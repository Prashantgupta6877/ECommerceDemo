package com.pguptafeb.ecommercedemo.constants

import java.util.*


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
enum class AppColorPatch(val appColor: String, val colorHex: String) {
    RED("red", "#AED11E"),
    SILVER("silver", "#AED11E"),
    BLUE("blue", "#AED11E"),
    GREEN("green", "#AED11E"),
    WHITE("white", "#FFFFFF")
}

fun String.getAppColorPatchInHex(): String {
    return AppColorPatch.values().find { it.appColor == toLowerCase(Locale.US) }?.colorHex
        ?: "#FFFFFF"
}