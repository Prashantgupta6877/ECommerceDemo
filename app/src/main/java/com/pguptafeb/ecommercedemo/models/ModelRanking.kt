package com.pguptafeb.ecommercedemo.models

import com.j256.ormlite.dao.ForeignCollection
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.field.ForeignCollectionField
import com.j256.ormlite.table.DatabaseTable
import com.squareup.moshi.Json


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

private const val TABLE_NAME_RANKING = "Ranking"
private const val RANKING_NAME = "ranking_name"
private const val RANKING_ID = "ranking_id"
private const val IS_SELECTED = "is_selected"

@DatabaseTable(tableName = TABLE_NAME_RANKING)
class ModelRanking {

    @Json(name = "ranking")
    @DatabaseField(columnName = RANKING_NAME)
    var rankingName: String = ""

    @DatabaseField(columnName = RANKING_ID, generatedId = true)
    var rankingId: Int = 0

    @Json(name = "products")
    var products: MutableList<ModelProductRanking>? = null

    var isSelected: Boolean = false

    @Transient
    @ForeignCollectionField
    var foreignCollectionProductRanking: ForeignCollection<ModelProductRanking>? = null
}


