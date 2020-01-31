package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

const val TABLE_NAME_RANKING_PRODUCTS = "RankingProducts"
const val VIEW_COUNT = "view_count"
const val ORDER_COUNT = "order_count"
const val SHARES = "shares"
const val OBJ_RANKING_ID = "obj_ranking_id"
const val COUNT = "count"

@DatabaseTable(tableName = TABLE_NAME_RANKING_PRODUCTS)
class ModelProductRanking /*: Comparable<Int>*/ {

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

   /* override fun compareTo(other: Int): Int {
        return if (count > other) 1 else 0
    }*/
}