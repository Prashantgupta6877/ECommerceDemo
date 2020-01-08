package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pguptafeb.ecommercedemo.constants.DATE_ADDED
import com.pguptafeb.ecommercedemo.constants.PRODUCT_ID
import com.pguptafeb.ecommercedemo.constants.PRODUCT_NAME
import com.pguptafeb.ecommercedemo.constants.PRODUCT_TABLE_NAME
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(tableName = PRODUCT_TABLE_NAME)
data class ModelProduct(

    @Json(name = "id")
    @ColumnInfo(name = PRODUCT_ID)
    @PrimaryKey
    var productId: Int? = null,

    @Json(name = "name")
    @ColumnInfo(name = PRODUCT_NAME)
    var productName: String,

    @Json(name = "date_added")
    @ColumnInfo(name = DATE_ADDED)
    var dateAdded: String,

    @Json(name = "variants")
    var variants: MutableList<ModelVariant>,

    var categoryId: Int,

    @Json(name = "tax")
    var modelTax: ModelProductTax
)