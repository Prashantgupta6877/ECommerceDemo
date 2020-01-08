package com.pguptafeb.ecommercedemo.screens.dashboard


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface DashboardContract {

    interface View {

    }

    interface Presenter {

    }

    interface Repository {

        fun getDataFromAPI()
    }
}