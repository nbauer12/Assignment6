package assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() throws Exception {
        customer1 = new Customer("Alice", 30);
        customer2 = new Customer("Bob", 25);
    }

    @Test
    void testGetName() {
        assertEquals("Alice", customer1.getName());
        assertEquals("Bob", customer2.getName());
    }

    @Test
    void testGetAge() {
        assertEquals(30, customer1.getAge());
        assertEquals(25, customer2.getAge());
    }

    @Test
    void testSetName() {
        customer1.setName("Carol");
        assertEquals("Carol", customer1.getName());

        customer2.setName("David");
        assertEquals("David", customer2.getName());
    }

    @Test
    void testSetAge() {
        customer1.setAge(35);
        assertEquals(35, customer1.getAge());

        customer2.setAge(28);
        assertEquals(28, customer2.getAge());
    }

    @Test
    void testToString() {
        assertEquals("Customer{name='Alice', age=30}", customer1.toString());
        assertEquals("Customer{name='Bob', age=25}", customer2.toString());
    }

    @Test
    void testCopyConstructor() {
        Customer customerCopy = new Customer(customer1);

        assertNotSame(customer1, customerCopy);
        assertEquals(customer1.getName(), customerCopy.getName());
        assertEquals(customer1.getAge(), customerCopy.getAge());
    }
}
