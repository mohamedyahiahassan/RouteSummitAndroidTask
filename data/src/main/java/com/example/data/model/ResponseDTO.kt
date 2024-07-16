package com.example.data.model

import com.example.domain.model.ProductsItem
import com.example.domain.model.Response
import com.google.gson.annotations.SerializedName

data class ResponseDTO(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("skip")
    val skip: Int? = null,

    @field:SerializedName("products")
    val products: List<ProductsItem?>? = null
){

    fun toResponse():Response{

        return Response(total, limit, skip, products)
    }
}
