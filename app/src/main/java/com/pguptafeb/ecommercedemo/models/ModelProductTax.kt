package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.pguptafeb.ecommercedemo.constants.TAX_NAME
import com.pguptafeb.ecommercedemo.constants.TAX_TABLE_NAME
import com.pguptafeb.ecommercedemo.constants.TAX_VALUE
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(tableName = TAX_TABLE_NAME)
data class ModelProductTax(

    @Json(name = "name")
    @ColumnInfo(name = TAX_NAME)
    var taxName: String,

    @Json(name = "value")
    @ColumnInfo(name = TAX_VALUE)
    var taxValue: Float,

    var productId: Int
)