package com.pguptafeb.ecommercedemo.screens.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        presenter.onLoad(false)
    }

    override fun setUpInitialUi() {
        rvProductList.layoutManager = LinearLayoutManager(this)
        rvProductList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        txtSort.setOnClickListener {
            val bottomSheet = SortingBottomSheet(this, presenter.rankingUserSelection)
            bottomSheet.show(supportFragmentManager, "")
        }

        edtProductSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                productAdapter.filter.filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun showProgressDialog(isShown: Boolean) {
        progressBar.visibility = if (isShown) VISIBLE else GONE
    }

    override fun showProductList(products: MutableList<ModelProduct>) {
        productAdapter = ProductListAdapters(products, supportFragmentManager)
        rvProductList.adapter = productAdapter
    }

    override fun onItemSelected(pickerItem: ModelRanking?) {
        pickerItem?.let {
            productAdapter.sortProductsBy(it)
            presenter.rankingUserSelection = pickerItem
        }
    }

    override fun showNativeAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setNeutralButton(getString(R.string.cancel)) { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}
