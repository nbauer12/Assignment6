package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

    private Coffee coffeeSmall;
    private Coffee coffeeMedium;
    private Coffee coffeeLarge;

    @BeforeEach
    void setUp() throws Exception {
        coffeeSmall = new Coffee("Mocha", Size.SMALL, true, true);
        coffeeMedium = new Coffee("Latte", Size.MEDIUM, false, true);
        coffeeLarge = new Coffee("Americano", Size.LARGE, true, false);
    }

    @Test
    void testGetExtraShot() {
        assertTrue(coffeeSmall.getExtraShot());
        assertFalse(coffeeMedium.getExtraShot());
        assertTrue(coffeeLarge.getExtraShot());
    }

    @Test
    void testGetExtraSyrup() {
        assertTrue(coffeeSmall.getExtraSyrup());
        assertTrue(coffeeMedium.getExtraSyrup());
        assertFalse(coffeeLarge.getExtraSyrup());
    }

    @Test
    void testCalcPrice() {
        assertEquals(3.0, coffeeSmall.calcPrice(), 0.0001);

        assertEquals(3.5, coffeeMedium.calcPrice(), 0.0001);

        assertEquals(4.5, coffeeLarge.calcPrice(), 0.0001);
    }

    @Test
    void testToString() {
        assertEquals("Beverage Name: Mocha, Type: Coffee, Size: SMALL, Extra Shot: Yes, Extra Syrup: Yes, Price: 3.0",
                coffeeSmall.toString());

        assertEquals("Beverage Name: Latte, Type: Coffee, Size: MEDIUM, Extra Shot: No, Extra Syrup: Yes, Price: 3.5",
                coffeeMedium.toString());

        assertEquals("Beverage Name: Americano, Type: Coffee, Size: LARGE, Extra Shot: Yes, Extra Syrup: No, Price: 4.5",
                coffeeLarge.toString());
    }
}
