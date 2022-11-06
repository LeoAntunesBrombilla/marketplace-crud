package com.marketplace.marketplacecrud.CustomerOrder

import com.marketplace.marketplacecrud.Product.ProductModel
import org.springframework.stereotype.Service

@Service
class CustomerOrderService {

    val orders = mutableListOf<CustomerOrderModel>()

    fun getAllOrders(): List<CustomerOrderModel> {
        return orders
    }

    fun createCustomerOrder(productList: List<ProductModel>) {
        val id = if (orders.isEmpty()) {
            1
        } else {
            orders.last().id.toInt() + 1
        }.toString()

        val totalPrice = productList.map { it.price }.reduce { acc, price -> acc + price }

        orders.add(CustomerOrderModel(id, productList, totalPrice))
    }

    fun removeCustomerOrder(id: String) {
        orders.removeIf { it.id === id }
    }

}

