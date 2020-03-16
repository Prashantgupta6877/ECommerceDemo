package com.pguptafeb.ecommercedemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pguptafeb.ecommercedemo.ECommerceApplication
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.models.ModelRanking
import kotlinx.android.synthetic.main.list_item_sorting_options.view.*


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class SortingOptionAdapter(
    private var rankings: MutableList<ModelRanking>,
    var rankingUserSelection: ModelRanking?,
    private val itemSelectedListener: OnSelectedItemListener
) : RecyclerView.Adapter<SortingOptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_sorting_options, parent, false)
        )
    }

    override fun getItemCount() = rankings.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelRanking = rankings[position]
        holder.txtSortingOption.text = modelRanking.rankingName
        if (rankingUserSelection?.rankingId == modelRanking.rankingId) {
            showItemSelected(true, holder.txtSortingOption)
        } else {
            showItemSelected(false, holder.txtSortingOption)
        }

        holder.txtSortingOption.setOnClickListener {
            modelRanking.isSelected = !modelRanking.isSelected
            showItemSelected(modelRanking.isSelected, holder.txtSortingOption)
            itemSelectedListener.onItemSelected(modelRanking)
        }
    }

    private fun showItemSelected(isSelected: Boolean, txtSortingOption: TextView) {
        if (isSelected) {
            txtSortingOption.setTextColor(
                ContextCompat.getColor(
                    ECommerceApplication.context,
                    R.color.redSort
                )
            )
            txtSortingOption.setBackgroundColor(
                ContextCompat.getColor(
                    ECommerceApplication.context,
                    R.color.activeBgColor
                )
            )
            txtSortingOption.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                ContextCompat.getDrawable(ECommerceApplication.context, R.drawable.red_check_mark),
                null
            )
        } else {
            txtSortingOption.setTextColor(
                ContextCompat.getColor(
                    ECommerceApplication.context,
                    R.color.black
                )
            )
            txtSortingOption.background = null
            txtSortingOption.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtSortingOption: TextView = itemView.txtSortingOption
    }

    interface OnSelectedItemListener {
        fun onItemSelected(pickerItem: ModelRanking?)
    }
}