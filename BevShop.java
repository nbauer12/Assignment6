package assignment6;

import java.util.*;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private int currentNumOfAlcoholDrinks;

    public BevShop() {
        this.orders = new ArrayList<>();
        this.currentNumOfAlcoholDrinks = 0;
    }
    
    public boolean isValidTime(int time) {
        return (time >= MIN_TIME && time <= MAX_TIME);
    }

    public boolean validTime(int time) {
        return (time >= MIN_TIME && time <= MAX_TIME);
    }

    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        } else {
            return 0;
        }
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    public boolean isEligibleForMore() {
        return currentNumOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        this.currentNumOfAlcoholDrinks = 0;
        orders.add(new Order(time, day, new Customer(customerName, customerAge)));
    }

    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Order currentOrder = orders.get(orders.size() - 1);
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            Order currentOrder = orders.get(orders.size() - 1);
            currentOrder.addNewBeverage(bevName, size);
            currentNumOfAlcoholDrinks++;
        }
    }

    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Order currentOrder = orders.get(orders.size() - 1);
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    public int getNumOfAlcoholDrink() {
        return this.currentNumOfAlcoholDrinks;
    }

    public Order getCurrentOrder() {
        return orders.get(orders.size() - 1);
    }

    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < orders.size(); j++)
                if (orders.get(j).getOrderNo() < orders.get(min_idx).getOrderNo())
                    min_idx = j;
            
            Collections.swap(orders, min_idx, i);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Order order : orders) {
            str += order.toString() + "\n";
        }
        str += "Total Monthly Sale: " + totalMonthlySale();
        return str;
    }
}
