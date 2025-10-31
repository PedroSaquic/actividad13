// Componente
public interface Product {
    String getDescription();
    double getPrice();
}

// Producto base
public class BaseProduct implements Product {
    private final String name;
    private final double price;

    public BaseProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Decorador abstracto
public abstract class ProductDecorator implements Product {
    protected final Product wrapped;

    public ProductDecorator(Product wrapped) {
        this.wrapped = wrapped;
    }
}

// Garantía extendida +10%
public class WarrantyDecorator extends ProductDecorator {
    public WarrantyDecorator(Product wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Extended Warranty";
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice() * 1.10; // +10%
    }
}

// Envoltorio regalo + GTQ5.00
public class GiftWrapDecorator extends ProductDecorator {
    public GiftWrapDecorator(Product wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Gift Wrap";
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice() + 5.00;
    }
}