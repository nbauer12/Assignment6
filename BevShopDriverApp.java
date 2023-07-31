package assignment6;

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        System.out.println("Start please a new order:");
        System.out.println("Would you please enter your name:");
        name = scanner.nextLine();
        System.out.println("Would you please enter your age:");
        age = scanner.nextInt();
        scanner.nextLine(); 
        bevShop.startNewOrder(9, Day.MONDAY, name, age);
        System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

        if (age >= 21) {
            System.out.println("Would you please add an alcohol drink");
            String alcoholDrink = scanner.nextLine();
            bevShop.processAlcoholOrder(alcoholDrink, Size.MEDIUM);
            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

            System.out.println("Would you please add a second alcohol drink");
            alcoholDrink = scanner.nextLine();
            bevShop.processAlcoholOrder(alcoholDrink, Size.LARGE);

            System.out.println("Add third alcohol drink");
            alcoholDrink = scanner.nextLine();
            bevShop.processAlcoholOrder(alcoholDrink, Size.SMALL);
            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
        }

        System.out.println("Would you please add a COFFEE to your order:");
        String coffee = scanner.nextLine();
        bevShop.processCoffeeOrder(coffee, Size.LARGE, true, false);
        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

        System.out.println("Would you please start a new order");
        System.out.println("Would you please enter your name:");
        name = scanner.nextLine();
        System.out.println("Would you please enter your age:");
        age = scanner.nextInt();
        scanner.nextLine(); 
        bevShop.startNewOrder(10, Day.TUESDAY, name, age);

        System.out.println("Would you please add a SMOOTHIE to order");
        String smoothie = scanner.nextLine();
        bevShop.processSmoothieOrder(smoothie, Size.MEDIUM, 3, false);

        System.out.println("Would you please add a SMOOTHIE to order");
        smoothie = scanner.nextLine();
        bevShop.processSmoothieOrder(smoothie, Size.SMALL, 2, true);

        System.out.println("Would you please add a COFFEE to order");
        coffee = scanner.nextLine();
        bevShop.processCoffeeOrder(coffee, Size.SMALL, false, false);
        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

        System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());

        scanner.close();
    }
}
