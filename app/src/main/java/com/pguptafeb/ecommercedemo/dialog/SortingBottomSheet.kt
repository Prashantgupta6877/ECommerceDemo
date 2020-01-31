package com.pguptafeb.ecommercedemo.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.adapters.SortingOptionAdapter
import com.pguptafeb.ecommercedemo.database.dao.RankingDao
import com.pguptafeb.ecommercedemo.models.ModelRanking
import kotlinx.android.synthetic.main.layout_sorting_bottom_sheet.*


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class SortingBottomSheet(
    private val onSelectedItemListener: OnSelectedItemListener,
    var rankingUserSelection: ModelRanking?
) :
    BottomSheetDialogFragment(),
    SortingOptionAdapter.OnSelectedItemListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(activity, R.layout.layout_sorting_bottom_sheet, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rankings = RankingDao.dao.queryBuilder().query()

        rvSortingOptions.layoutManager = LinearLayoutManager(activity)
        rvSortingOptions.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        rvSortingOptions.adapter = SortingOptionAdapter(rankings, rankingUserSelection,this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState)
        bottomSheetDialog.setOnShowListener {
            val bottomSheet: FrameLayout =
                bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet.let {
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.isHideable = false
            }
        }
        return bottomSheetDialog
    }

    override fun onItemSelected(pickerItem: ModelRanking?) {
        onSelectedItemListener.onItemSelected(pickerItem)
        dismiss()
    }

    interface OnSelectedItemListener {
        fun onItemSelected(pickerItem: ModelRanking?)
    }
}