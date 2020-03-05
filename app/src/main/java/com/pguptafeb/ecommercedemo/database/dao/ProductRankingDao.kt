package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.*

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductRankingDao {

    var dao: Dao<ModelProductRanking, Int> =
        BaseDatabase.getDao(ModelProductRanking::class.java)

    fun fetchRankingProducts(modelRanking: ModelRanking): MutableList<ModelProductRanking>? {
        val rankingProductQueryBuilder = dao.queryBuilder()
        rankingProductQueryBuilder.selectColumns(OBJ_PRODUCT_ID)
        rankingProductQueryBuilder.where().eq(OBJ_RANKING_ID, modelRanking.rankingId)
        rankingProductQueryBuilder.orderBy(COUNT, false)
        return rankingProductQueryBuilder.query()
    }
}