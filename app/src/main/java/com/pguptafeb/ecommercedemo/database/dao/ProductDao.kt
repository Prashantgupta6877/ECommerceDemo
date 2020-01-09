package com.pguptafeb.ecommercedemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pguptafeb.ecommercedemo.models.ModelCategory
import com.pguptafeb.ecommercedemo.models.ModelProduct

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ModelProduct)
}