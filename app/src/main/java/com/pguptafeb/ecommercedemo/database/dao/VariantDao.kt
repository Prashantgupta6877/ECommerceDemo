package com.pguptafeb.ecommercedemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pguptafeb.ecommercedemo.models.ModelCategory
import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelVariant

@Dao
interface VariantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllVariant(variants: MutableList<ModelVariant>)
}