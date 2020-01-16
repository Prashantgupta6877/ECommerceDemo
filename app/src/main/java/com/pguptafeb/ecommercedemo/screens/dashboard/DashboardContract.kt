package com.pguptafeb.ecommercedemo.screens.dashboard


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface DashboardContract {

    interface View {
        fun showProgressDialog(isShown: Boolean)
    }

    interface Presenter {

        fun onLoad()

    }

    interface Repository {

        fun getDataFromAPI()
    }
}