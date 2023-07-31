package assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTestStudent {
    private Alcohol alcohol1, alcohol2, alcohol3;

    @BeforeEach
    void setUp() {
        alcohol1 = new Alcohol("Wine", Size.MEDIUM, false);
        alcohol2 = new Alcohol("Wine", Size.MEDIUM, false);
        alcohol3 = new Alcohol("Beer", Size.LARGE, true);
    }

    @Test
    void calcPrice() {
        assertEquals(3.0, alcohol1.calcPrice());
        assertEquals(4.6, alcohol3.calcPrice());
    }

    @Test
    void testEquals() {
        assertTrue(alcohol1.equals(alcohol2));
        assertFalse(alcohol1.equals(alcohol3));
    }

    @Test
    void testToString() {
        String expected1 = "Beverage Name: Wine, Type: ALCOHOL, Size: MEDIUM, Is weekend: false, Price: 3.0";
        String expected3 = "Beverage Name: Beer, Type: ALCOHOL, Size: LARGE, Is weekend: true, Price: 4.6";
        assertEquals(expected1, alcohol1.toString());
        assertEquals(expected3, alcohol3.toString());
    }

}
