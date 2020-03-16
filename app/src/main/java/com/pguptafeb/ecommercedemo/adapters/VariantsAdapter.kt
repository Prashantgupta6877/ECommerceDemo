package com.pguptafeb.ecommercedemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.constants.getAppColorPatchInHex
import com.pguptafeb.ecommercedemo.extensions.toNotNullString
import com.pguptafeb.ecommercedemo.models.ModelVariant
import kotlinx.android.synthetic.main.list_item_products.view.*

/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class VariantsAdapter(
    private var variants: MutableList<ModelVariant>
) : RecyclerView.Adapter<VariantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_available_variants, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = variants.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(variants[position]) {
            holder.txtSize.text = variantSize.toNotNullString()
            holder.txtPrice.text = variantPrice.toString()
            holder.setImageColor(variantColor.toString())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtSize: TextView = itemView.txtSize
        private val imgColor: ImageView = itemView.imgColorPatch
        val txtPrice: TextView = itemView.txtPrice

        fun setImageColor(colorName: String) {
            imgColor.setBackgroundColor(Color.parseColor(colorName.getAppColorPatchInHex()))
        }
    }
}
