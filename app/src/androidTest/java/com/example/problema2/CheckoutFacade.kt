package com.example.problema2

class CheckoutFacade(
    private val paymentGateway: PaymentGateway,
    private val orderService: OrderService
) {
    suspend fun checkout(cart: Cart, customer: Customer): CheckoutResult {
        val total = cart.getTotal()
        val payment = paymentGateway.charge(customer, total)
        return if (payment.success) {
            val order = orderService.createOrder(cart, customer)
            CheckoutResult(true, order.confirmationId)
        } else {
            CheckoutResult(false, null)
        }
    }
}