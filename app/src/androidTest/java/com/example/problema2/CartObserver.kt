package com.example.problema2

interface CartObserver { fun onCartChanged(total: Double) }

class Cart {
    private val observers = mutableListOf<CartObserver>()
    private val items = mutableListOf<Product>()

    fun addProduct(p: Product) {
        items.add(p); notifyObservers()
    }

    fun removeProduct(p: Product) {
        items.remove(p); notifyObservers()
    }

    fun getTotal(): Double = items.sumOf { it.getPrice() }

    fun register(o: CartObserver) { observers.add(o) }
    fun unregister(o: CartObserver) { observers.remove(o) }

    private fun notifyObservers() {
        val total = getTotal()
        observers.forEach { it.onCartChanged(total) }
    }
}