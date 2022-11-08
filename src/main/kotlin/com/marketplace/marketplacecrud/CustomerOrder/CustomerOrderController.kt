package com.marketplace.marketplacecrud.CustomerOrder

import com.marketplace.marketplacecrud.Product.ProductModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("customer-order")
class CustomerOrderController(
    val customerOrderService: CustomerOrderService
) {

    @GetMapping
    fun getAllOrders(): List<CustomerOrderModel> {
        return customerOrderService.getAllOrders()
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: String): CustomerOrderModel {
        return customerOrderService.getOrderById(id)
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomerOrder(@RequestBody productList: List<ProductModel>) {
        return customerOrderService.createCustomerOrder(productList)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomerOrder(@RequestBody id: String) {
        return customerOrderService.deleteCustomerOrder(id)
    }
}