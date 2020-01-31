package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

const val TABLE_NAME_VARIANT = "Variant"
const val VARIANT_ID = "variant_id"
const val VARIANT_COLOR = "variant_color"
const val VARIANT_SIZE = "variant_size"
const val VARIANT_PRICE = "variant_price"
const val OBJ_PRODUCT_ID = "obj_product_id"

@DatabaseTable(tableName = TABLE_NAME_VARIANT)
data class ModelVariant(

    @Json(name = "id")
    @DatabaseField(columnName = VARIANT_ID, id = true)
    var variantId: Int = 0,

    @Json(name = "color")
    @DatabaseField(columnName = VARIANT_COLOR)
    var variantColor: String? = null,

    @Json(name = "size")
    @DatabaseField(columnName = VARIANT_SIZE)
    var variantSize: Int? = null,

    @Json(name = "price")
    @DatabaseField(columnName = VARIANT_PRICE)
    var variantPrice: Long = 0,

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = OBJ_PRODUCT_ID)
    var modelProduct: ModelProduct? = null
)