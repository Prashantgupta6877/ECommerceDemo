package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.pguptafeb.ecommercedemo.constants.RANKING_ID
import com.pguptafeb.ecommercedemo.constants.RANKING_NAME
import com.pguptafeb.ecommercedemo.constants.TABLE_NAME_RANKING
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
@DatabaseTable(tableName = TABLE_NAME_RANKING)
class ModelRanking {

    @Json(name = "ranking")
    @DatabaseField(columnName = RANKING_NAME)
    var rankingName: String = ""

    @DatabaseField(columnName = RANKING_ID, generatedId = true)
    var rankingId: Int = 0

    @Json(name = "products")
    var products: MutableList<ModelProductRanking>? = null
}


