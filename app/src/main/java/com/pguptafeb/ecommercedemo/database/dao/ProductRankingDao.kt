package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProductRanking


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductRankingDao {

    var dao: Dao<ModelProductRanking, Int> =
        BaseDatabase.getDao(ModelProductRanking::class.java)
}