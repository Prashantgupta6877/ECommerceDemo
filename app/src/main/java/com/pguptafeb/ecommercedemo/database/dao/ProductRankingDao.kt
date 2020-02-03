package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProductRanking
import com.pguptafeb.ecommercedemo.models.ModelRanking

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductRankingDao {

    var dao: Dao<ModelProductRanking, Int> =
        BaseDatabase.getDao(ModelProductRanking::class.java)

    fun fetchRankingProducts(modelRanking: ModelRanking): MutableList<ModelProductRanking>? {
        val rankingProductQueryBuilder = dao.queryBuilder()
        rankingProductQueryBuilder.selectColumns("obj_product_id")
        rankingProductQueryBuilder.where().eq("obj_ranking_id", modelRanking.rankingId)
        rankingProductQueryBuilder.orderBy("count", false)
        return rankingProductQueryBuilder.query()
    }
}