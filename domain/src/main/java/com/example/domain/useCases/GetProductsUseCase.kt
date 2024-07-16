package com.example.domain.useCases

import android.annotation.SuppressLint
import com.example.domain.Resource
import com.example.domain.contract.repository.ProductRepository
import com.example.domain.model.ProductsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {


    @SuppressLint("SuspiciousIndentation")
    suspend operator fun invoke():Flow<Resource<MutableList<ProductsItem>>> = flow {

        val listOfProducts = mutableListOf<ProductsItem>()

        emit(Resource.Loading())

        val result = try {

        val response =  productRepository.getProducts().products

            response?.forEach {productsItem->

                if (productsItem != null) {
                    listOfProducts.add(productsItem)
                }
            }

            Resource.Success(listOfProducts)
        } catch (e:Exception){

            Resource.Error(e.message.toString())
        }

        emit(result)
    }
}