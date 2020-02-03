package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProduct

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductDao {

    val dao: Dao<ModelProduct, Int> = BaseDatabase.getDao(ModelProduct::class.java)

    fun fetchProducts(): MutableList<ModelProduct>? = dao.queryBuilder().query()
}
