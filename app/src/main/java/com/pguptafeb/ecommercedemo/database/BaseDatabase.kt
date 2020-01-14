package com.pguptafeb.ecommercedemo.database

import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import com.pguptafeb.ecommercedemo.ECommerceApplication
import com.pguptafeb.ecommercedemo.models.*

private const val DB_NAME = "ECommerce"
private const val DB_VERSION = 1

object BaseDatabase: OrmLiteSqliteOpenHelper(ECommerceApplication.context, DB_NAME, null, DB_VERSION) {

    init {
        val db = writableDatabase
        db.execSQL("PRAGMA foreign_keys = ON;")
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource, ModelCategory::class.java)
        TableUtils.createTableIfNotExists(connectionSource, ModelProduct::class.java)
        TableUtils.createTableIfNotExists(connectionSource, ModelVariant::class.java)
        TableUtils.createTableIfNotExists(connectionSource, ModelProductTax::class.java)
        TableUtils.createTableIfNotExists(connectionSource, ModelRanking::class.java)
        TableUtils.createTableIfNotExists(connectionSource, ModelProductRanking::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {

    }
}