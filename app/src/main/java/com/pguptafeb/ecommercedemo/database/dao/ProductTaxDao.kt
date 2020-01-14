package com.pguptafeb.ecommercedemo.database.dao

import com.j256.ormlite.dao.Dao
import com.pguptafeb.ecommercedemo.constants.OBJ_PRODUCT_ID
import com.pguptafeb.ecommercedemo.constants.TAX_NAME
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelProductTax


/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
object ProductTaxDao {
    private val dao: Dao<ModelProductTax, Int> = BaseDatabase.getDao(ModelProductTax::class.java)

    private fun fetchTaxFor(productId: Int, taxName: String) =
        dao.queryBuilder().where().eq(TAX_NAME, taxName).and().eq(
            OBJ_PRODUCT_ID, productId
        ).queryForFirst()

    fun createOrUpdateProductTax(modelProductTax: ModelProductTax) {

        val oldProductTax =
            fetchTaxFor(modelProductTax.modelProduct?.productId ?: 0, modelProductTax.taxName ?: "")

        if (oldProductTax != null) {
            oldProductTax.taxValue = modelProductTax.taxValue
            dao.update(oldProductTax)
        } else {
            dao.create(modelProductTax)
        }
    }
}