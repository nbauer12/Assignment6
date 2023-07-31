package assignment6;

public abstract class Beverage {

    private final static double BASE_PRICE = 2.0; 
    private final static double SIZE_PRICE = 1; 

    private String bevName;
    private Type type;
    private Size size;

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public String getBevName() {
        return this.bevName;
    }

    public Type getType() {
        return this.type;
    }

    public Size getSize() {
        return this.size;
    }

    protected double getBasePrice() {
        return BASE_PRICE;
    }

    public double addSizePrice() {
        double basePrice = getBasePrice();
        switch (size) {
            case SMALL:
                break;
            case MEDIUM:
                basePrice += SIZE_PRICE;
                break;
            case LARGE:
                basePrice += 2 * SIZE_PRICE;
                break;
        }
        return basePrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return bevName.equals(beverage.bevName) &&
                type == beverage.type &&
                size == beverage.size;
    }

    @Override
    public String toString() {
        return "Beverage Name: " + bevName + ", Type: " + type + ", Size: " + size;
    }

    public abstract double calcPrice();
}
