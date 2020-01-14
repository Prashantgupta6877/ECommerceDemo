package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.pguptafeb.ecommercedemo.constants.CATEGORY_ID
import com.pguptafeb.ecommercedemo.constants.CATEGORY_NAME
import com.pguptafeb.ecommercedemo.constants.TABLE_NAME_CATEGORY
import com.squareup.moshi.Json

/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@DatabaseTable(tableName = TABLE_NAME_CATEGORY)
class ModelCategory {

    @Json(name = "id")
    @DatabaseField(columnName = CATEGORY_ID, id = true)
    var categoryId: Int = 0

    @Json(name = "name")
    @DatabaseField(columnName = CATEGORY_NAME)
    var categoryName: String? = null

    @Json(name = "products")
    var products: MutableList<ModelProduct>? = null
}