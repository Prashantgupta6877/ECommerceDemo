package com.pguptafeb.ecommercedemo.screens.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pguptafeb.ecommercedemo.R

class SortFilterActivity : AppCompatActivity(), SortFilterContracts.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort_filter)
    }
}
