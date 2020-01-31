package com.pguptafeb.ecommercedemo.network

import com.pguptafeb.ecommercedemo.models.ModelServerResponse
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */
interface ApiService {

    @GET("5e26f4472f0000afa3a4f8af")
    fun getAllProducts():Observable<ModelServerResponse>
}