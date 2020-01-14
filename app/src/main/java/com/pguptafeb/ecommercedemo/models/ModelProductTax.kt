package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.pguptafeb.ecommercedemo.constants.*
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
@DatabaseTable(tableName = TABLE_NAME_TAX)
class ModelProductTax {

    @DatabaseField(columnName = TAX_ID, generatedId = true)
    var id: Int = 0

    @Json(name = "name")
    @DatabaseField(columnName = TAX_NAME)
    var taxName: String? = null

    @Json(name = "value")
    @DatabaseField(columnName = TAX_VALUE)
    var taxValue: Float = 0.0f

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = OBJ_PRODUCT_ID)
    var modelProduct: ModelProduct? = null

}