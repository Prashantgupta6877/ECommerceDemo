package com.pguptafeb.ecommercedemo.screens.dashboard

class DashboardPresenterImpl(
    private val view: DashboardContract.View,
    private val repository: DashboardContract.Repository
) : DashboardContract.Presenter, DashboardRepositoryImpl.GetApiResponseListener {


    override fun onLoad() {

        repository.getDataFromAPI()

    }

    override fun onSuccess() {

    }

    override fun onFail(message: String) {

    }
}