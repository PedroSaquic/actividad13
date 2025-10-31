class InventoryViewModel(private val stockSubject: StockSubject) : ViewModel(), StockObserver {

    private val _stockLiveData = MutableLiveData<Pair<Long, Int>>()
    val stockLiveData: LiveData<Pair<Long, Int>> = _stockLiveData

    init { stockSubject.register(this) }

    override fun onCleared() {
        super.onCleared()
        stockSubject.unregister(this)
    }

    override fun onStockChanged(productId: Long, newStock: Int) {
        _stockLiveData.postValue(productId to newStock)
    }
}