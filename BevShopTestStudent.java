package assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BevShopTestStudent {
    private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
        bevShop.startNewOrder(15, Day.MONDAY, "Alice", 30);
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        bevShop.processSmoothieOrder("Tropical", Size.MEDIUM, 3, true);
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);

        double totalOrderPrice = bevShop.totalOrderPrice(1);
        assertEquals(12.5, totalOrderPrice, 0.001);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        bevShop.processCoffeeOrder("Cappuccino", Size.SMALL, true, false);
        bevShop.processSmoothieOrder("Tropical", Size.MEDIUM, 2, true);
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);

        int totalNumOfMonthlyOrders = bevShop.totalNumOfMonthlyOrders();
        assertEquals(2, totalNumOfMonthlyOrders);
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(5));
        assertTrue(bevShop.isValidTime(22));
        assertFalse(bevShop.isValidTime(25));
    }

    @Test
    public void testIsMaxFruit() {
        assertFalse(bevShop.isMaxFruit(3));
        assertTrue(bevShop.isMaxFruit(5));
        assertFalse(bevShop.isMaxFruit(4));
    }

    @Test
    public void testIsEligibleForMore() {
        assertTrue(bevShop.isEligibleForMore());
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(18));
        assertFalse(bevShop.isValidAge(17));
        assertTrue(bevShop.isValidAge(25));
        assertFalse(bevShop.isValidAge(30));
    }
}
