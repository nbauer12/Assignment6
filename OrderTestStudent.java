package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTestStudent {

    private Order order1;

    @BeforeEach
    public void setup() {
        Customer customer1 = new Customer("John", 25);
        order1 = new Order(10, Day.SATURDAY, customer1);

        // Add beverages to the order
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order1.addNewBeverage("Mocha", Size.SMALL, false, true);
        order1.addNewBeverage("IPA", Size.LARGE);
    }

    @Test
    public void testOrderDetails() {
        assertEquals(1, order1.getOrderNo());
        assertEquals(10, order1.getOrderTime());
        assertEquals(Day.SATURDAY, order1.getDay());
        assertEquals("John", order1.getCustomer().getName());
        assertEquals(true, order1.isWeekend());
        assertEquals(3, order1.getTotalItems());
    }

    @Test
    public void testBeveragesInOrder() {
        Beverage beverage1 = order1.getBeverage(0);
        assertEquals("Latte", beverage1.getBevName());
        assertEquals(Size.MEDIUM, beverage1.getSize());
        assertEquals(3.5, beverage1.calcPrice());

        Beverage beverage2 = order1.getBeverage(1);
        assertEquals("Mocha", beverage2.getBevName());
        assertEquals(Size.SMALL, beverage2.getSize());
        assertEquals(2.5, beverage2.calcPrice());

        Beverage beverage3 = order1.getBeverage(2);
        assertEquals("IPA", beverage3.getBevName());
        assertEquals(Size.LARGE, beverage3.getSize());
        assertEquals(4.6, beverage3.calcPrice());
    }

    @Test
    public void testTotalOrderAmount() {
        assertEquals(10.6, order1.calcOrderTotal());
    }
}
