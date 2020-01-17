package com.pguptafeb.ecommercedemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.constants.getAppColorPatchInHex
import com.pguptafeb.ecommercedemo.extensions.toNotNullString
import com.pguptafeb.ecommercedemo.models.ModelProduct
import kotlinx.android.synthetic.main.list_item_products.view.*

/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class ProductListAdapters(
    private var products: MutableList<ModelProduct>
) : RecyclerView.Adapter<ProductListAdapters.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_products, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(products[position]) {

            holder.txtCategoryName.text = String.format("(%s)", modelCategory?.categoryName)
            holder.txtProductName.text = productName

            foreignCollectionVariant?.let { variants ->
                holder.showMoreOptionView(variants.size > 1)
                variants.toMutableList()[0]?.run {
                    holder.txtSize.text = variantSize.toNotNullString()
                    holder.txtPrice.text = variantPrice.toString()
                    holder.setImageColor(variantColor.toString())
                }
            }

            holder.showVatView(taxName?.isNotEmpty() ?: true)
            holder.txtTaxTitle.text = String.format("• %s-", taxName)
            holder.txtTaxPercentage.text = taxValue.toString()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCategoryName: TextView = itemView.txtCategoryName
        val txtProductName: TextView = itemView.txtProductName
        val txtSize: TextView = itemView.txtSize
        val txtTaxTitle: TextView = itemView.txtVatTitle
        val txtTaxPercentage: TextView = itemView.txtVatPercentage
        val imgColor: ImageView = itemView.imgColorPatch
        val txtPrice: TextView = itemView.txtPrice

        fun showVatView(isVisible: Boolean) {
            itemView.grpVat.visibility = if (isVisible) VISIBLE else GONE
        }

        fun showMoreOptionView(isVisible: Boolean) {
            itemView.txtMore.visibility = if (isVisible) VISIBLE else GONE
        }

        fun setImageColor(colorName: String) {
            imgColor.setBackgroundColor(Color.parseColor(colorName.getAppColorPatchInHex()))
        }
    }
}