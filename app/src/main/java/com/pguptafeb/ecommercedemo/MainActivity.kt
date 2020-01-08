package com.pguptafeb.ecommercedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import com.pguptafeb.ecommercedemo.network.ApiBuilder
import com.pguptafeb.ecommercedemo.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ApiBuilder.create().getAllProducts()
        request.enqueue(object : Callback<ModelServerResponse> {
            override fun onFailure(call: Call<ModelServerResponse>, t: Throwable) {
                println("response ----------->${t.message}")
            }

            override fun onResponse(call: Call<ModelServerResponse>, response: Response<ModelServerResponse>) {
                println("response ------------->${response.body().toString()}")
                txt.text = response.body().toString()
            }
        })

    }
}
