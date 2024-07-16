package com.example.data.api

import com.example.data.model.ResponseDTO
import retrofit2.http.GET

interface WebService {

    @GET("products")
   suspend fun getAllProducts(): ResponseDTO

}