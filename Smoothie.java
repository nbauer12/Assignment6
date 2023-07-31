package assignment6;

public class Smoothie extends Beverage {
    private int numFruits;
    private boolean proteinAdded;
    
    public static final double COST_OF_FRUIT = 0.5;
    public static final double COST_OF_PROTEIN = 1.5;

    public Smoothie(String bevName, Size size, int numFruits, boolean proteinAdded) {
        super(bevName, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.proteinAdded = proteinAdded;
    }

    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean getAddProtein() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }

    @Override
    public double calcPrice() {
        double price = super.addSizePrice() + (numFruits * COST_OF_FRUIT);
        if (proteinAdded) {
            price += COST_OF_PROTEIN;
        }
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Smoothie)) return false;
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numFruits == smoothie.numFruits && proteinAdded == smoothie.proteinAdded;
    }

    @Override
    public String toString() {
        return "Beverage Name: " + getBevName() + ", Type: Smoothie, Size: " + getSize() +
               ", Number of Fruits: " + numFruits + ", Protein Added: " + (proteinAdded ? "Yes" : "No") +
               ", Price: " + calcPrice();
    }
}
