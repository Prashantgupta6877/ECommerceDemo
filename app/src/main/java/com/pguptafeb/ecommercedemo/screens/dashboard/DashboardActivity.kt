package com.pguptafeb.ecommercedemo.screens.dashboard

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.adapters.ProductListAdapters
import com.pguptafeb.ecommercedemo.dialog.SortingBottomSheet
import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelRanking
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : FragmentActivity(), DashboardContract.View,
    SortingBottomSheet.OnSelectedItemListener {

    private lateinit var presenter: DashboardContract.Presenter
    private lateinit var productAdapter: ProductListAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        presenter = DashboardPresenterImpl(this, DashboardRepositoryImpl())
        presenter.setUpInitialUi()
        presenter.onLoad(true)
    }

    override fun setUpInitialUi() {
        rvProductList.layoutManager = LinearLayoutManager(this)
        rvProductList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        txtSort.setOnClickListener {
            val bottomSheet = SortingBottomSheet(this, presenter.rankingUserSelection)
            bottomSheet.show(supportFragmentManager, "")
        }
    }

    override fun showProgressDialog(isShown: Boolean) {
        progressBar.visibility = if (isShown) VISIBLE else GONE
    }

    override fun showProductList(products: MutableList<ModelProduct>) {
        productAdapter = ProductListAdapters(products)
        rvProductList.adapter = productAdapter
    }

    override fun onItemSelected(pickerItem: ModelRanking?) {
        pickerItem?.let {
            productAdapter.sortProductsBy(it)
            presenter.rankingUserSelection = pickerItem
        }
    }
}
