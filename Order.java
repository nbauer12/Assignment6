package assignment6;

import java.util.ArrayList;

public class Order implements OrderInterface {
    private int orderNo;
    private int orderTime;
    private Day day;
    private ArrayList<Beverage> bevList;
    private static int numOrders = 0;
    private Customer customer; 

    public Order(int orderTime, Day day, Customer customer) { 
        this.orderTime = orderTime;
        this.day = day;
        this.customer = customer;
        bevList = new ArrayList<>();
        orderNo = numOrders++;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getDay() {
        return day;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public boolean isWeekend() {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : bevList) {
            total += b.calcPrice();
        }
        return total;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        bevList.add(coffee);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
        bevList.add(alcohol);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtien) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtien);
        bevList.add(smoothie);
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : bevList) {
            if (b.getType() == type) {
                count++;
            }
        }
        return count;
    }
    

    @Override
    public Beverage getBeverage(int index) {
        if(index >= 0 && index < bevList.size()) {
            return bevList.get(index);
        }
        return null;
    }

    public int getTotalItems() {
        return bevList.size();
    }
}
