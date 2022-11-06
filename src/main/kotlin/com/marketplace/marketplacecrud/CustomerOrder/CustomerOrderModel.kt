package com.marketplace.marketplacecrud.CustomerOrder

import com.marketplace.marketplacecrud.Product.ProductModel

data class CustomerOrderModel(
    val id: String,

    val listOfProducts: List<ProductModel>,

    val totalPrice: Double
)
