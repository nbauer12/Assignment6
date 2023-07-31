package assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeverageTestStudent {

    private Beverage beverage1;
    private Beverage beverage2;
    private Beverage beverage3;

    @BeforeEach
    void setUp() {
        beverage1 = new Alcohol("Wine", Size.SMALL, false);
        beverage2 = new Alcohol("Beer", Size.MEDIUM, false);
        beverage3 = new Alcohol("Vodka", Size.LARGE, true);
    }

    @Test
    void testGetBevName() {
        assertEquals("Wine", beverage1.getBevName());
        assertEquals("Beer", beverage2.getBevName());
        assertEquals("Vodka", beverage3.getBevName());
    }

    @Test
    void testGetType() {
        assertEquals(Type.ALCOHOL, beverage1.getType());
        assertEquals(Type.ALCOHOL, beverage2.getType());
        assertEquals(Type.ALCOHOL, beverage3.getType());
    }

    @Test
    void testGetSize() {
        assertEquals(Size.SMALL, beverage1.getSize());
        assertEquals(Size.MEDIUM, beverage2.getSize());
        assertEquals(Size.LARGE, beverage3.getSize());
    }

    @Test
    void testAddSizePrice() {
        assertEquals(2.0, beverage1.addSizePrice());
        assertEquals(3.0, beverage2.addSizePrice());
        assertEquals(4.0, beverage3.addSizePrice());
    }

    @Test
    void testEquals() {
        Beverage sameAsBev1 = new Alcohol("Wine", Size.SMALL, false);
        assertTrue(beverage1.equals(sameAsBev1));
        assertFalse(beverage1.equals(beverage2));
    }

    @Test
    void testToString() {
        String expected1 = "Beverage Name: Wine, Type: ALCOHOL, Size: SMALL, Is weekend: false, Price: 2.0";
        String expected2 = "Beverage Name: Beer, Type: ALCOHOL, Size: MEDIUM, Is weekend: false, Price: 3.0";
        String expected3 = "Beverage Name: Vodka, Type: ALCOHOL, Size: LARGE, Is weekend: true, Price: 4.6";
        assertEquals(expected1, beverage1.toString());
        assertEquals(expected2, beverage2.toString());
        assertEquals(expected3, beverage3.toString());
    }
}
