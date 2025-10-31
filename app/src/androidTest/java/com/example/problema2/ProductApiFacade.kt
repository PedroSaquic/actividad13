class ProductApiFacade(private val api: ProductApi = RetrofitInstance.productApi) {
    suspend fun getProducts() = safeApiCall { api.getProducts() }
    // create/update/delete ...
}