package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SizeTestStudent {

    @Test
    public void testSizeEnum() {
        assertEquals(Size.SMALL, Size.valueOf("SMALL"));
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
        assertEquals(Size.LARGE, Size.valueOf("LARGE"));
    }
}
