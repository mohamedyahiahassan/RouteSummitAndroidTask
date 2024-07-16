package com.example.domain.contract.repository

import com.example.domain.model.Response

interface ProductRepository {

    suspend fun getProducts():Response
}