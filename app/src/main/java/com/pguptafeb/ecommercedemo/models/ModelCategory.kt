package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pguptafeb.ecommercedemo.constants.CATEGORY_ID
import com.pguptafeb.ecommercedemo.constants.CATEGORY_NAME
import com.pguptafeb.ecommercedemo.constants.CATEGORY_TABLE_NAME
import com.squareup.moshi.Json

/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(tableName = CATEGORY_TABLE_NAME)
data class ModelCategory(

    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = CATEGORY_ID)
    var categoryId: Int,

    @Json(name = "name")
    @ColumnInfo(name = CATEGORY_NAME)
    var categoryName: String,

    @Json(name = "products")
    var products: MutableList<ModelProduct>
)