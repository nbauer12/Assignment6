package assignment6;

public class Coffee extends Beverage {
    
    private boolean extraShot;
    private boolean extraSyrup;
    
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return this.extraShot;
    }

    public boolean getExtraSyrup() {
        return this.extraSyrup;
    }

    @Override
    public double calcPrice() {
        double basePrice = super.addSizePrice();
        if (extraShot) {
            basePrice += 0.5; 
        }
        if (extraSyrup) {
            basePrice += 0.5; 
        }
        return basePrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coffee coffee = (Coffee) obj;
        return getBevName().equals(coffee.getBevName()) &&
                getSize() == coffee.getSize() &&
                extraShot == coffee.extraShot &&
                extraSyrup == coffee.extraSyrup;
    }

    @Override
    public String toString() {
        return "Beverage Name: " + getBevName() + ", Type: Coffee, Size: " + getSize() +
               ", Extra Shot: " + (extraShot ? "Yes" : "No") + ", Extra Syrup: " + (extraSyrup ? "Yes" : "No") +
               ", Price: " + calcPrice();
    }
}
