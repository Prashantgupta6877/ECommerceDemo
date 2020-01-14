package com.pguptafeb.ecommercedemo.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.stetho.Stetho
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.database.dao.*
import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import com.pguptafeb.ecommercedemo.network.ApiBuilder
import com.pguptafeb.ecommercedemo.network.ApiService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private var compositeDisposable: CompositeDisposable? = null
    private var request: ApiService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this)

        compositeDisposable = CompositeDisposable()
        request = ApiBuilder.create()

        fetchData()

    }

    private fun fetchData() {
        request?.getAllProducts()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ModelServerResponse> {

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable?.add(d)
                }

                override fun onNext(response: ModelServerResponse) {

                    response.categories.forEach {
                        CategoryDao.dao.createOrUpdate(it)
                        it.products?.forEach { modelProduct ->

                            modelProduct.modelCategory = it

                            ProductDao.dao.createOrUpdate(modelProduct)

                            modelProduct.variants?.forEach { modelVariant ->
                                modelVariant.modelProduct = modelProduct
                                VariantDao.dao.createOrUpdate(modelVariant)
                            }

                            modelProduct.modelProductTax?.let { modelTax ->

                                modelTax.modelProduct = modelProduct
                                ProductTaxDao.createOrUpdateProductTax(modelTax)
                            }
                        }
                    }

                    response.rankings.forEach { modelRanking ->
                        RankingDao.createRanking(modelRanking)

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
}
