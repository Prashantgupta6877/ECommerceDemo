package com.pguptafeb.ecommercedemo.models

import androidx.room.*
import com.facebook.stetho.inspector.protocol.module.DatabaseConstants
import com.pguptafeb.ecommercedemo.constants.*
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

@Entity(
    tableName = PRODUCT_TABLE_NAME/*,
    foreignKeys = [ForeignKey(
        entity = ModelCategory::class,
        parentColumns = [CATEGORY_ID],
        childColumns = [CATEGORY_ID]
    )]*/
)
class ModelProduct {
    @Json(name = "id")
    @ColumnInfo(name = PRODUCT_ID)
    @PrimaryKey
    var productId: Int? = null

    @Json(name = "name")
    @ColumnInfo(name = PRODUCT_NAME)
    var productName: String? = null

    @Json(name = "date_added")
    @ColumnInfo(name = DATE_ADDED)
    var dateAdded: String? = null

    @Json(name = "variants")
    @Ignore
    var variants: MutableList<ModelVariant>? = null

    @ForeignKey(entity = ModelCategory::class, parentColumns = [CATEGORY_ID], childColumns = [CATEGORY_ID])
    var categoryId: Int = 0

    @Json(name = "tax")
    @Ignore
    var modelProductTax: ModelProductTax? = null
}