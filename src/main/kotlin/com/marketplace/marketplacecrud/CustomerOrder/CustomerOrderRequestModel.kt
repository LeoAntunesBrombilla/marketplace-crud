package com.marketplace.marketplacecrud.CustomerOrder

import com.marketplace.marketplacecrud.Product.ProductModel

data class CustomerOrderRequestModel(
    val listOfProducts: List<ProductModel>,

    val totalPrice: Double
)
