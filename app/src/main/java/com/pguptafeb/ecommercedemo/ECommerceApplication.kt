package com.pguptafeb.ecommercedemo

import android.app.Application
import android.content.Context

/**
 * Created by Prashant G. Gupta on 14, Jan 2020
 */
class ECommerceApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}