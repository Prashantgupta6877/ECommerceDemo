package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.dao.ForeignCollection
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.field.ForeignCollectionField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json

/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
const val TABLE_NAME_PRODUCT = "Product"
const val PRODUCT_ID = "product_id"
const val PRODUCT_NAME = "product_name"
const val DATE_ADDED = "date_added"
const val TAX_NAME = "tax_name"
const val TAX_VALUE = "tax_value"
const val OBJ_CATEGORY_ID = "obj_category_id"

@DatabaseTable(tableName = TABLE_NAME_PRODUCT)
class ModelProduct {
    @Json(name = "id")
    @DatabaseField(columnName = PRODUCT_ID, id = true)
    var productId: Int = 0

    @Json(name = "name")
    @DatabaseField(columnName = PRODUCT_NAME)
    var productName: String? = null

    @Json(name = "date_added")
    @DatabaseField(columnName = DATE_ADDED)
    var dateAdded: String? = null

    @Json(name = "variants")
    var variants: MutableList<ModelVariant>? = null

    @Json(name = "tax")
    var modelProductTax: ModelProductTax? = null

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = OBJ_CATEGORY_ID)
    var modelCategory: ModelCategory? = null

    @DatabaseField(columnName = TAX_NAME)
    var taxName: String? = null

    @DatabaseField(columnName = TAX_VALUE)
    var taxValue: Float? = null

    @Transient
    @ForeignCollectionField
    var foreignCollectionVariant: ForeignCollection<ModelVariant>? = null

    @Transient
    @ForeignCollectionField
    var foreignCollectionProductRanking: ForeignCollection<ModelProductRanking>? = null
}