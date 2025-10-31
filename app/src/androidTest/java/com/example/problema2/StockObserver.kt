
interface StockObserver {
    fun onStockChanged(productId: Long, newStock: Int)
}

class StockSubject {
    private val observers = mutableSetOf<StockObserver>()

    fun register(observer: StockObserver) {
        observers.add(observer)
    }

    fun unregister(observer: StockObserver) {
        observers.remove(observer)
    }

    fun notifyStockChanged(productId: Long, newStock: Int) {
        for (obs in observers) {
            obs.onStockChanged(productId, newStock)
        }
    }
}