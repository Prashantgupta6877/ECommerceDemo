package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.constants.COUNT
import com.pguptafeb.ecommercedemo.constants.OBJ_PRODUCT_ID
import com.pguptafeb.ecommercedemo.constants.OBJ_RANKING_ID
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProductRanking


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductRankingDao {

    var dao: Dao<ModelProductRanking, Int> =
        BaseDatabase.getDao(ModelProductRanking::class.java)


    fun createOrUpdateProductRankingCount(modelProductRanking: ModelProductRanking) {
        val oldProductRanking = fetchProductRanking(modelProductRanking)
        if (oldProductRanking != null) {
            oldProductRanking.count = modelProductRanking.count
            dao.update(oldProductRanking)
        } else {
            dao.create(modelProductRanking)
        }
    }

    private fun fetchProductRanking(modelProductRanking: ModelProductRanking) =
        dao.queryBuilder().where()
            .eq(OBJ_RANKING_ID, modelProductRanking.modelRanking?.rankingId).and()
            .eq(OBJ_PRODUCT_ID, modelProductRanking.modelProduct?.productId).queryForFirst()

}