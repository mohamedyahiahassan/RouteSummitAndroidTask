package com.example.data.contract.repostory

import com.example.data.api.WebService
import com.example.domain.Resource
import com.example.domain.contract.repository.ProductRepository
import com.example.domain.model.ProductsItem
import com.example.domain.model.Response
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class ProductRepoImplTest {

    lateinit var productRepository: ProductRepository

    val webService = mockk<WebService>()

    @Before
    fun setUp() {

        productRepository = ProductRepoImpl(webService)

    }

    @Test
    fun `when call getProduct from ProductRepoImpl it should get data from api`() = runTest {


        val response = Response()


        coEvery { webService.getAllProducts().toResponse() } returns response

        val result = productRepository.getProducts()


        assertEquals(response,result)


    }


}