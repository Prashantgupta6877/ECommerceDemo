package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.pguptafeb.ecommercedemo.constants.PRODUCT_ID
import com.pguptafeb.ecommercedemo.constants.TAX_NAME
import com.pguptafeb.ecommercedemo.constants.TAX_TABLE_NAME
import com.pguptafeb.ecommercedemo.constants.TAX_VALUE
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(tableName = TAX_TABLE_NAME)
data class ModelProductTax(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @Json(name = "name")
    @ColumnInfo(name = TAX_NAME)
    var taxName: String,

    @Json(name = "value")
    @ColumnInfo(name = TAX_VALUE)
    var taxValue: Float,

    @ForeignKey(
        entity = ModelProduct::class,
        parentColumns = [PRODUCT_ID],
        childColumns = [PRODUCT_ID]
    )
    var productId: Int
)