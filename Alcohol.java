package assignment6;

public class Alcohol extends Beverage {


    private final static double ALCOHOL_PRICE = 2.0; 


    private boolean isWeekend;


    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend()) {
            price += 0.60;
        }
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Alcohol alcohol = (Alcohol) obj;
        return isWeekend == alcohol.isWeekend;
    }

    @Override
    public String toString() {
        return super.toString() + ", Is weekend: " + isWeekend + ", Price: " + calcPrice();
    }
}


