package com.pguptafeb.ecommercedemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pguptafeb.ecommercedemo.database.dao.CategoryDao
import com.pguptafeb.ecommercedemo.database.dao.ProductDao
import com.pguptafeb.ecommercedemo.database.dao.ProductTaxDao
import com.pguptafeb.ecommercedemo.database.dao.VariantDao
import com.pguptafeb.ecommercedemo.models.*

@Database(
    entities = [ModelCategory::class, ModelProduct::class, ModelVariant::class
        , ModelProductTax::class], version = 1, exportSchema = false
)
abstract class BaseDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
    abstract fun variantDao(): VariantDao
    abstract fun productTaxDao(): ProductTaxDao

    companion object {

        private var INSTANCE: BaseDatabase? = null

        fun getDatabase(context: Context): BaseDatabase? {
            if (INSTANCE == null) {
                synchronized(BaseDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        BaseDatabase::class.java, "chapter.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}