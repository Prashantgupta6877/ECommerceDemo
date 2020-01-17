package com.pguptafeb.ecommercedemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.models.ModelRanking
import kotlinx.android.synthetic.main.list_item_sorting_options.view.*


/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class SortingOptionAdapter(
    private var rankings: MutableList<ModelRanking>,
    private val itemSelectedListener: OnSelectedItemListener
) : RecyclerView.Adapter<SortingOptionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_sorting_options, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = rankings.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelRanking = rankings[position]
        holder.txtSortingOption.text = modelRanking.rankingName

        holder.txtSortingOption.setOnClickListener {
            itemSelectedListener.onItemSelected(modelRanking)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtSortingOption: TextView = itemView.txtSortingOption
    }

    interface OnSelectedItemListener {
        fun onItemSelected(pickerItem: ModelRanking?)
    }
}