public class Demo {
    public static void main(String[] args) {
        Product p = new BaseProduct("Mochila", 199.00);

        // aplicar garantía y envoltura
        Product withWarranty = new WarrantyDecorator(p);
        Product fullyDecorated = new GiftWrapDecorator(withWarranty);

        System.out.println("Descripción: " + fullyDecorated.getDescription());
        System.out.println("Precio total: GTQ " + String.format("%.2f", fullyDecorated.getPrice()));
    }
}