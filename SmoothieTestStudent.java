package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

    private Smoothie smoothie1;
    private Smoothie smoothie2;

    @BeforeEach
    void setUp() throws Exception {
        smoothie1 = new Smoothie("Fruit Blast", Size.MEDIUM, 3, true);
        smoothie2 = new Smoothie("Green Delight", Size.LARGE, 2, false);
    }

    @Test
    void testGetNumFruits() {
        assertEquals(3, smoothie1.getNumFruits());
        assertEquals(2, smoothie2.getNumFruits());
    }

    @Test
    void testSetNumFruits() {
        smoothie1.setNumFruits(4);
        assertEquals(4, smoothie1.getNumFruits());

        smoothie2.setNumFruits(1);
        assertEquals(1, smoothie2.getNumFruits());
    }

    @Test
    void testGetAddProtein() {
        assertTrue(smoothie1.getAddProtein());
        assertFalse(smoothie2.getAddProtein());
    }

    @Test
    void testSetProteinAdded() {
        smoothie1.setProteinAdded(false);
        assertFalse(smoothie1.getAddProtein());

        smoothie2.setProteinAdded(true);
        assertTrue(smoothie2.getAddProtein());
    }

    @Test
    void testCalcPrice() {
        assertEquals(6, smoothie1.calcPrice(), 0.01);

        assertEquals(5, smoothie2.calcPrice(), 0.01);
    }

    @Test
    void testEquals() {
        Smoothie smoothie3 = new Smoothie("Fruit Blast", Size.MEDIUM, 3, true);

        assertTrue(smoothie1.equals(smoothie3));
        assertFalse(smoothie1.equals(smoothie2));
    }

    @Test
    void testToString() {
        assertEquals("Beverage Name: Fruit Blast, Type: Smoothie, Size: MEDIUM, Number of Fruits: 3, Protein Added: Yes, Price: 6.0",
                smoothie1.toString());

        assertEquals("Beverage Name: Green Delight, Type: Smoothie, Size: LARGE, Number of Fruits: 2, Protein Added: No, Price: 5.0",
                smoothie2.toString());
    }
}
