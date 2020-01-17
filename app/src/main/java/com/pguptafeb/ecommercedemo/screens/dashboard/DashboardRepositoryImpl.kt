package com.pguptafeb.ecommercedemo.screens.dashboard

import com.pguptafeb.ecommercedemo.database.dao.*
import com.pguptafeb.ecommercedemo.models.ModelCategory
import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelRanking
import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import com.pguptafeb.ecommercedemo.network.ApiBuilder
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DashboardRepositoryImpl : DashboardContract.Repository {

    override fun getDataFromAPI(apiResponseListener: GetApiResponseListener) {
        ApiBuilder.create().getAllProducts().subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ModelServerResponse> {

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: ModelServerResponse) {

                    storeCategories(response.categories)

                    storeRanking(response.rankings)
                    apiResponseListener.onSuccess()
                }

                override fun onError(e: Throwable) {
                    e.message?.let {
                        apiResponseListener.onFail(it)
                    }
                }
            })
    }


    private fun storeCategories(categories: MutableList<ModelCategory>) {
        categories.forEach {
            CategoryDao.dao.createOrUpdate(it)
            storeProducts(it, it.products)
        }
    }

    private fun storeProducts(category: ModelCategory, products: MutableList<ModelProduct>?) {
        products?.forEach { modelProduct ->
            modelProduct.modelCategory = category
            modelProduct.taxName = modelProduct.modelProductTax?.taxName
            modelProduct.taxValue = modelProduct.modelProductTax?.taxValue
            ProductDao.dao.createOrUpdate(modelProduct)
            storeVariants(modelProduct)
        }
    }

    private fun storeVariants(modelProduct: ModelProduct) {
        modelProduct.variants?.forEach { modelVariant ->
            modelVariant.modelProduct = modelProduct
            VariantDao.dao.createOrUpdate(modelVariant)
        }
    }

    private fun storeRanking(rankings: MutableList<ModelRanking>) {
        rankings.forEach { modelRanking ->
            RankingDao.dao.createOrUpdate(modelRanking)
            storeProductRanking(modelRanking)
        }
    }

    private fun storeProductRanking(modelRanking: ModelRanking) {
        modelRanking.products?.forEach { modelProductRanking ->
            ProductDao.dao.queryForId(modelProductRanking.id)?.let {
                modelProductRanking.modelProduct = it
            }
            modelProductRanking.modelRanking = modelRanking

            modelProductRanking.count =
                when {
                    modelProductRanking.viewCount > 0 -> modelProductRanking.viewCount
                    modelProductRanking.orderCount > 0 -> modelProductRanking.orderCount
                    else -> modelProductRanking.shares
                }
            ProductRankingDao.dao.createOrUpdate(modelProductRanking)
        }
    }

    override fun fetchProductList() = ProductDao.fetchProducts()

    interface GetApiResponseListener {

        fun onSuccess()

        fun onFail(message: String)
    }
}