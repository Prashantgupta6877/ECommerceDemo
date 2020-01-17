package com.pguptafeb.ecommercedemo.screens.dashboard

import com.pguptafeb.ecommercedemo.models.ModelProduct


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface DashboardContract {

    interface View {
        fun showProgressDialog(isShown: Boolean)

        fun showProductList(products: MutableList<ModelProduct>)
    }

    interface Presenter {

        fun onLoad(isOnline: Boolean)

        fun setProductList()
    }

    interface Repository {

        fun getDataFromAPI(apiResponseListener: DashboardRepositoryImpl.GetApiResponseListener)

        fun fetchProductList(): MutableList<ModelProduct>?
    }
}