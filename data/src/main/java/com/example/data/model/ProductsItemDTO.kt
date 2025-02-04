package com.example.data.model

import com.example.domain.model.Dimensions
import com.example.domain.model.Meta
import com.example.domain.model.ProductsItem
import com.example.domain.model.ReviewsItem
import com.google.gson.annotations.SerializedName

data class ProductsItemDTO(

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = null,

    @field:SerializedName("rating")
    val rating: Double? = null,

    @field:SerializedName("returnPolicy")
    val returnPolicy: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("weight")
    val weight: Int? = null,

    @field:SerializedName("warrantyInformation")
    val warrantyInformation: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null,

    @field:SerializedName("discountPercentage")
    val discountPercentage: Double? = null,

    @field:SerializedName("reviews")
    val reviews: List<ReviewsItem?>? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("shippingInformation")
    val shippingInformation: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("availabilityStatus")
    val availabilityStatus: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("stock")
    val stock: Int? = null,

    @field:SerializedName("sku")
    val sku: String? = null,

    @field:SerializedName("dimensions")
    val dimensions: Dimensions? = null,

    @field:SerializedName("brand")
    val brand: String? = null
){
    fun toProductsItem(): ProductsItem {

        return ProductsItem(
            images, thumbnail, minimumOrderQuantity, rating, returnPolicy, description, weight,
            warrantyInformation,title, tags, discountPercentage, reviews, price, meta, shippingInformation,
            id, availabilityStatus, category, stock, sku, dimensions, brand)

    }
}