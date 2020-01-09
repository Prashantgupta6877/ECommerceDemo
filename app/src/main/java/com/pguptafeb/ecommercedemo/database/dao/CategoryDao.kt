package com.pguptafeb.ecommercedemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pguptafeb.ecommercedemo.models.ModelCategory

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: ModelCategory)
}