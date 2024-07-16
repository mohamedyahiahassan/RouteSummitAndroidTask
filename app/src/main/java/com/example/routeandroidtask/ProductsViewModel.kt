package com.example.routeandroidtask

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.model.ProductsItem
import com.example.domain.useCases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
   private val getProductsUseCase: GetProductsUseCase
):ViewModel() {

    val listOfProducts = mutableStateListOf<ProductsItem>()

    val isLoading = mutableStateOf(true)



    fun getProductList() {

        if (listOfProducts.isEmpty()) {

            viewModelScope.launch(Dispatchers.IO) {

                getProductsUseCase.invoke().collect {

                    when (it) {
                        is Resource.Error -> {

                            Log.e("error fetching products", it.message.toString())

                            isLoading.value = false
                        }

                        is Resource.Loading -> {

                            isLoading.value = true
                        }

                        is Resource.Success -> {

                            if (it.data?.isNotEmpty() == true){

                                it.data?.let { it1 -> listOfProducts.addAll(it1) }


                            }

                            isLoading.value = false

                        }
                    }
                }
            }


        }
    }

}