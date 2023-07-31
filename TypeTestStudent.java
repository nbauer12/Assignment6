package assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TypeTestStudent {

    @Test
    public void testTypeEnum() {
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
        assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
        assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
    }
}
