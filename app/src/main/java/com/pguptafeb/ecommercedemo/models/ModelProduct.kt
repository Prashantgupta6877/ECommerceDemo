package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
data class ModelProduct(

    @Json(name = "id")
    var productId: Int? = null,

    @Json(name = "name")
    var productName: String,

    @Json(name = "date_added")
    var dateAdded: String,

    @Json(name = "variants")
    var variants: MutableList<ModelVariant>,

    var categoryId: Int,

    @Json(name = "tax")
    var modelTax: ModelProductTax
)