package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
data class ModelVariant(

    var productId: Int = 0,

    @Json(name = "id")
    var variantId: Int = 0,

    @Json(name = "color")
    var variantColor: String? = null,

    @Json(name = "size")
    var variantSize: Int? = null,

    @Json(name = "price")
    var variantPrice: Long = 0
)