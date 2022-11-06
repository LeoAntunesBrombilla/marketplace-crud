package com.marketplace.marketplacecrud.Product

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController(
    val productService: ProductService
) {

    @GetMapping
    fun getListOfProducts(): List<ProductModel> {
        return productService.getListOfProducts()
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String): ProductModel {
        return productService.getProduct(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody product: ProductRequestModel) {
        productService.addProduct(product)
   }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateProduct(@PathVariable id: String, @RequestBody product: ProductRequestModel) {
        productService.updateProduct(id, product)
   }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable id: String) {
        productService.deleteProduct(id)
    }
}