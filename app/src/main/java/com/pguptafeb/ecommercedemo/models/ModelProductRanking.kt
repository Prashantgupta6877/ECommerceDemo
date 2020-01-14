package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.pguptafeb.ecommercedemo.constants.*
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
@DatabaseTable(tableName = TABLE_NAME_RANKING_PRODUCTS)
class ModelProductRanking {

    @Json(name = "id")
    var id = 0

    @Json(name = VIEW_COUNT)
    var viewCount = 0

    @Json(name = SHARES)
    var shares = 0

    @Json(name = ORDER_COUNT)
    var orderCount = 0

    @DatabaseField(columnName = "product_ranking_id", generatedId = true)
    var productRankingId = 0

    @DatabaseField(columnName = COUNT)
    var count = 0

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = OBJ_RANKING_ID)
    var modelRanking: ModelRanking? = null

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = OBJ_PRODUCT_ID)
    var modelProduct: ModelProduct? = null
}