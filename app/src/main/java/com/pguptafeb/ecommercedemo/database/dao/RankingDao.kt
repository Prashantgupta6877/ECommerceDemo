package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.constants.RANKING_NAME
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelRanking


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object RankingDao {
    val dao: Dao<ModelRanking, Int> = BaseDatabase.getDao(ModelRanking::class.java)

    private fun fetchRankingFor(rankingName: String) =
        dao.queryBuilder().where().eq(
            RANKING_NAME, rankingName
        ).queryForFirst()

    fun createRanking(modelRanking: ModelRanking) {
        val oldRanking = fetchRankingFor(modelRanking.rankingName)
        if (oldRanking == null) {
            dao.create(modelRanking)
        }
    }
}