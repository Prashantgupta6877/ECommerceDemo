package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.pguptafeb.ecommercedemo.constants.*
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
@Entity(tableName = VARIANT_TABLE_NAME)
data class ModelVariant(

    @ForeignKey(
        entity = ModelProduct::class,
        parentColumns = [PRODUCT_ID],
        childColumns = [PRODUCT_ID]
    )
    var productId: Int = 0,

    @Json(name = "id")
    @ColumnInfo(name = VARIANT_ID)
    @PrimaryKey
    var variantId: Int = 0,

    @Json(name = "color")
    @ColumnInfo(name = VARIANT_COLOR)
    var variantColor: String? = null,

    @Json(name = "size")
    @ColumnInfo(name = VARIANT_SIZE)
    var variantSize: Int? = null,

    @Json(name = "price")
    @ColumnInfo(name = VARIANT_PRICE)
    var variantPrice: Long = 0
)