package com.pguptafeb.ecommercedemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.pguptafeb.ecommercedemo.constants.CATEGORY_ID
import com.pguptafeb.ecommercedemo.constants.CATEGORY_NAME
import com.pguptafeb.ecommercedemo.constants.CATEGORY_TABLE_NAME
import com.squareup.moshi.Json

/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(tableName = CATEGORY_TABLE_NAME)
class ModelCategory {
    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = CATEGORY_ID)
    var categoryId: Int = 0

    @Json(name = "name")
    @ColumnInfo(name = CATEGORY_NAME)
    var categoryName: String? = null

    @Json(name = "products")
    @Ignore
    var products: MutableList<ModelProduct>? = null
}