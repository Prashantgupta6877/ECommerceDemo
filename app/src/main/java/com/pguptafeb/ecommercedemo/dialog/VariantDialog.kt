package com.pguptafeb.ecommercedemo.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pguptafeb.ecommercedemo.R
import com.pguptafeb.ecommercedemo.adapters.VariantsAdapter
import com.pguptafeb.ecommercedemo.models.ModelVariant
import kotlinx.android.synthetic.main.dialog_variant_list.view.*

class VariantDialog(private var variants: MutableList<ModelVariant>) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_variant_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.rvVariantList.layoutManager = LinearLayoutManager(activity)
        view.rvVariantList.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        view.rvVariantList.adapter = VariantsAdapter(variants)

        view.imgClose.setOnClickListener {
            dismiss()
        }
    }
}