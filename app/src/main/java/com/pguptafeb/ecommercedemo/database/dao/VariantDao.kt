package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelVariant


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object VariantDao {

    val dao: Dao<ModelVariant, Int> = BaseDatabase.getDao(ModelVariant::class.java)

}