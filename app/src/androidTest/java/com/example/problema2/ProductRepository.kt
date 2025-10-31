package com.example.problema2

class ProductRepository(private val facade: ProductApiFacade) {
    suspend fun loadProducts(): List<Product> {
        val result = facade.getProducts()
        // map DTO -> BaseProduct domain objects
        return result.getOrThrow().map { dto -> BaseProduct(dto.name, dto.price) }
    }
}