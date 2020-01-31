package com.pguptafeb.ecommercedemo.screens.dashboard

import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelRanking


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface DashboardContract {

    interface View {
        fun showProgressDialog(isShown: Boolean)

        fun showProductList(products: MutableList<ModelProduct>)

        fun setUpInitialUi()
    }

    interface Presenter {
        var rankingUserSelection: ModelRanking?

        fun onLoad(isOnline: Boolean)

        fun setProductList()

        fun setUpInitialUi()
    }

    interface Repository {

        fun getDataFromAPI(apiResponseListener: DashboardRepositoryImpl.GetApiResponseListener)

        fun fetchProductList(): MutableList<ModelProduct>?

        fun clearAllTableData()
    }
}