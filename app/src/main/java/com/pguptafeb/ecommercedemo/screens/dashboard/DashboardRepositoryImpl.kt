package com.pguptafeb.ecommercedemo.screens.dashboard

import com.pguptafeb.ecommercedemo.database.dao.*
import com.pguptafeb.ecommercedemo.models.*
import com.pguptafeb.ecommercedemo.network.ApiBuilder
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DashboardRepositoryImpl : DashboardContract.Repository {


    override fun getDataFromAPI() {
        ApiBuilder.create().getAllProducts().subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ModelServerResponse> {

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: ModelServerResponse) {

                    storeCategories(response.categories)

                    response.rankings.forEach { modelRanking ->
                        RankingDao.dao.createOrUpdate(modelRanking)

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
                }

                override fun onError(e: Throwable) {
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
            ProductDao.dao.createOrUpdate(modelProduct)
            storeVariants(modelProduct)
            storeTax(modelProduct)
        }
    }

    private fun storeTax(modelProduct: ModelProduct) {
        modelProduct.modelProductTax?.let { modelTax ->

            modelTax.modelProduct = modelProduct
            ProductTaxDao.createOrUpdateProductTax(modelTax)
        }
    }

    private fun storeVariants(modelProduct: ModelProduct) {
        modelProduct.variants?.forEach { modelVariant ->
            modelVariant.modelProduct = modelProduct
            VariantDao.dao.createOrUpdate(modelVariant)
        }
    }

    interface GetApiResponseListener {

        fun onSuccess()

        fun onFail(message: String)
    }
}