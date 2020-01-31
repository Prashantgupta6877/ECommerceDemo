package com.pguptafeb.ecommercedemo.screens.dashboard

import com.pguptafeb.ecommercedemo.models.ModelRanking

class DashboardPresenterImpl(
    private val view: DashboardContract.View,
    private val repository: DashboardContract.Repository
) : DashboardContract.Presenter, DashboardRepositoryImpl.GetApiResponseListener {

    override var rankingUserSelection: ModelRanking? = null

    override fun setUpInitialUi() {
        view.setUpInitialUi()
    }

    override fun onLoad(isOnline: Boolean) {

        if (isOnline) {
            view.showProgressDialog(true)
            repository.getDataFromAPI(this)
        } else {
            setProductList()
        }
    }

    override fun onSuccess() {
        view.showProgressDialog(false)
        setProductList()
    }

    override fun onFail(message: String) {
        view.showProgressDialog(false)
    }

    override fun setProductList() {
        repository.fetchProductList()?.let {
            view.showProductList(it)
        }
    }
}