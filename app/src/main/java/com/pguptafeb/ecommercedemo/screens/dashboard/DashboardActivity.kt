package com.pguptafeb.ecommercedemo.screens.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pguptafeb.ecommercedemo.R

class DashboardActivity : AppCompatActivity(), DashboardContract.View {

    private lateinit var presenter: DashboardContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        presenter = DashboardPresenterImpl(this, DashboardRepositoryImpl())
        presenter.onLoad()
    }

    override fun showProgressDialog(isShown: Boolean) {

    }
}
