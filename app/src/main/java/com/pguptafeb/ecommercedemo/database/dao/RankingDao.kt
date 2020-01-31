package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelRanking

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object RankingDao {
    val dao: Dao<ModelRanking, Int> = BaseDatabase.getDao(ModelRanking::class.java)
}