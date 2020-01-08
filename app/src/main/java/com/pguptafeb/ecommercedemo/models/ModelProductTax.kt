package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
data class ModelProductTax(

    @Json(name = "name")
    var taxName: String,

    @Json(name = "value")
    var taxValue: Float,

    var productId: Int
)