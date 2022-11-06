package com.marketplace.marketplacecrud.Product

import org.springframework.stereotype.Service

@Service
class ProductService {

    val products = mutableListOf<ProductModel>()

    fun getListOfProducts(): List<ProductModel> {
        return products
    }

    fun getProduct(id: String): ProductModel {
        return products.filter { it.id == id }.first()
    }

    fun addProduct(product: ProductRequestModel) {
        val id = if (products.isEmpty()) {
            1
        } else {
            products.last().id.toInt() + 1
        }.toString()

        products.add(ProductModel(id, product.name, product.price))
    }

    fun updateProduct(id: String, product: ProductRequestModel) {
        products.filter { it.id == id }.first().let {
            it.name = product.name
            it.price = product.price
        }
    }

    fun deleteProduct(id: String) {
        products.removeIf { it.id == id }
    }
}