package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProductTax

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductTaxDao {
    val dao: Dao<ModelProductTax, Int> = BaseDatabase.getDao(ModelProductTax::class.java)
}