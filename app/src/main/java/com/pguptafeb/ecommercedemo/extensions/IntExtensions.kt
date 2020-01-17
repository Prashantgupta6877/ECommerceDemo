package com.pguptafeb.ecommercedemo.extensions


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
fun Int?.toNotNullString(): String {
    return this?.toString() ?: "N/A"
}