package com.pguptafeb.ecommercedemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.constants.getAppColorPatchInHex
import com.pguptafeb.ecommercedemo.database.dao.ProductRankingDao
import com.pguptafeb.ecommercedemo.database.dao.RankingDao
import com.pguptafeb.ecommercedemo.dialog.VariantDialog
import com.pguptafeb.ecommercedemo.extensions.toNotNullString
import com.pguptafeb.ecommercedemo.models.ModelProduct
import com.pguptafeb.ecommercedemo.models.ModelRanking
import com.pguptafeb.ecommercedemo.models.ModelVariant
import kotlinx.android.synthetic.main.list_item_products.view.*
import java.util.*

/**
 * Created by Prashant G. Gupta on 17, Jan 2020
 */
class ProductListAdapters(
    private var products: MutableList<ModelProduct>,
    private var supportFragment: FragmentManager
) : RecyclerView.Adapter<ProductListAdapters.ViewHolder>(), Filterable {

    private var mFilteredProducts = mutableListOf<ModelProduct>()

    init {
        mFilteredProducts = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_products, parent, false)
        return ViewHolder(view, supportFragment)
    }

    override fun getItemCount() = mFilteredProducts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(mFilteredProducts[position]) {

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

            holder.onMoreClick(foreignCollectionVariant?.toMutableList())
        }
    }

    class ViewHolder(itemView: View, private val supportFragment: FragmentManager) :
        RecyclerView.ViewHolder(itemView) {
        val txtCategoryName: TextView = itemView.txtCategoryName
        val txtProductName: TextView = itemView.txtProductName
        val txtSize: TextView = itemView.txtSize
        val txtTaxTitle: TextView = itemView.txtVatTitle
        val txtTaxPercentage: TextView = itemView.txtVatPercentage
        private val imgColor: ImageView = itemView.imgColorPatch
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

        fun onMoreClick(variants: MutableList<ModelVariant>?) {
            variants?.let { variantList ->
                itemView.txtMore.setOnClickListener {
                    val dialog = VariantDialog(variantList)
                    dialog.show(supportFragment, "")
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                mFilteredProducts = if (constraint?.isEmpty()!!) {
                    products
                } else {
                    val filteredList = mutableListOf<ModelProduct>()

                    for (modelProduct: ModelProduct in products) {
                        if (modelProduct.productName?.toLowerCase(Locale.US)?.contains(
                                constraint.toString().toLowerCase(Locale.US)
                            ) == true ||
                            modelProduct.modelCategory?.categoryName?.toLowerCase(Locale.US)?.contains(
                                constraint.toString().toLowerCase(
                                    Locale.US
                                )
                            ) == true
                        )
                            filteredList.add(modelProduct)
                    }

                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = mFilteredProducts
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mFilteredProducts = results?.values as MutableList<ModelProduct>
                notifyDataSetChanged()
            }
        }
    }

    fun sortProductsBy(modelRanking: ModelRanking) {

        val rankingProducts = ProductRankingDao.fetchRankingProducts(modelRanking)
        val listNotMatch = mutableListOf<ModelProduct>()

        rankingProducts?.forEach { rankedProduct ->
            listNotMatch.add(rankedProduct.modelProduct!!)
            products.filter { it.productId == rankedProduct.modelProduct?.productId }
                .map { products.remove(it) }

        }
        listNotMatch.addAll(products)
        products.clear()
        products.addAll(listNotMatch)
        notifyDataSetChanged()
    }
}
