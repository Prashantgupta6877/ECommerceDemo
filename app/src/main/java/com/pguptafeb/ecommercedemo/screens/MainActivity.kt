package com.pguptafeb.ecommercedemo.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.stetho.Stetho
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.database.BaseDatabase
import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import com.pguptafeb.ecommercedemo.network.ApiBuilder
import com.pguptafeb.ecommercedemo.network.ApiService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private var compositDisposable: CompositeDisposable? = null
    private var request: ApiService? = null
    private var db: BaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this)

        compositDisposable = CompositeDisposable()
        request = ApiBuilder.create()
        db = BaseDatabase.getDatabase(this@MainActivity)

        fetchData()

    }

    private fun fetchData() {
        request?.getAllProducts()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ModelServerResponse> {

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    compositDisposable?.add(d)
                }

                override fun onNext(response: ModelServerResponse) {

                    response.categories.forEach { category ->

                        db?.categoryDao()?.insertCategory(category)

                        category.products?.forEach { product ->

                            db?.productDao()?.insertProduct(product)

                            product.variants?.let {
                                db?.variantDao()?.insertAllVariant(it)
                            }

                            product.modelProductTax?.let {
                                db?.productTaxDao()?.insertProductTax(it)
                            }
                        }

                    }
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}
