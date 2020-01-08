package com.pguptafeb.ecommercedemo.models

import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
data class ModelServerResponse(
    @Json(name = "categories")
    var categories: MutableList<ModelCategory>,

    @Json(name = "rankings")
    var rankings: MutableList<ModelRanking>
)