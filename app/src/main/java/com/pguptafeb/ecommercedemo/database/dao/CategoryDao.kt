package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelCategory


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object CategoryDao {

    val dao: Dao<ModelCategory, Int> = BaseDatabase.getDao(ModelCategory::class.java)
}
