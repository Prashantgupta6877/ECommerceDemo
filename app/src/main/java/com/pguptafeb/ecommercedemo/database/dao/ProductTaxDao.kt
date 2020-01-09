package com.pguptafeb.ecommercedemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pguptafeb.ecommercedemo.models.ModelCategory
import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelProductTax
import com.pguptafeb.ecommercedemo.models.ModelVariant

@Dao
interface ProductTaxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductTax(tax: ModelProductTax)
}