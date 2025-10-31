class ProductApiFacade(private val api: ProductApi) {

    suspend fun fetchAll(): Result<List<ProductDto>> {
        return safeApiCall { api.getProducts() }
    }

    suspend fun create(product: ProductDto): Result<ProductDto> {
        return safeApiCall { api.createProduct(product) }
    }

    suspend fun update(id: Long, product: ProductDto): Result<ProductDto> {
        return safeApiCall { api.updateProduct(id, product) }
    }

    suspend fun delete(id: Long): Result<Unit> {
        return safeApiCall { api.deleteProduct(id) }
    }

    // helper to centralize error handling / mapping
    private inline fun <T> safeApiCall(block: () -> T): Result<T> {
        return try {
            Result.success(block())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}