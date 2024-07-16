package com.example.data.contract.repostory

import com.example.data.api.WebService
import com.example.domain.contract.repository.ProductRepository
import com.example.domain.model.Response
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(private val webService: WebService):ProductRepository {

    override suspend fun getProducts():Response {

        return webService.getAllProducts().toResponse()

    }
}