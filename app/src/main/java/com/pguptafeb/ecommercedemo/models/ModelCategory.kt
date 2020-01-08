package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json

/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
data class ModelCategory(

    @Json(name = "id")
    var categoryId: Int,

    @Json(name = "name")
    var categoryName: String,

    @Json(name = "products")
    var products: MutableList<ModelProduct>
)