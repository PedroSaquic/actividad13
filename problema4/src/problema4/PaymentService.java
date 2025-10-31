public class PaymentService {
    public void printCurrency() {
        String currency = AppConfig.getInstance().getCurrency();
        System.out.println("Usando moneda: " + currency);
    }
}