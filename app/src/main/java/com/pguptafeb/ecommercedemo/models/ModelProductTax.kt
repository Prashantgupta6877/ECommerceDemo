package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
class ModelProductTax {

    @Json(name = "name")
    var taxName: String? = null

    @Json(name = "value")
    var taxValue: Float = 0.0f

}