public class AppConfig {
    private static volatile AppConfig instance;
    private String currency;
    private double taxPercentage;

    private AppConfig() {
        // valores por defecto
        this.currency = "GTQ";
        this.taxPercentage = 0.12; // 12%
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // getters y setters
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getTaxPercentage() { return taxPercentage; }
    public void setTaxPercentage(double taxPercentage) { this.taxPercentage = taxPercentage; }
}