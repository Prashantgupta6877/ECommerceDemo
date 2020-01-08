package com.pguptafeb.ecommercedemo.network

import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface ApiService {

    @GET("json")
    fun getAllProducts(): Call<ModelServerResponse>
}