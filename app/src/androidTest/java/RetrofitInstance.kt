object RetrofitInstance {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.tienda.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productApi: ProductApi = retrofit.create(ProductApi::class.java)
}