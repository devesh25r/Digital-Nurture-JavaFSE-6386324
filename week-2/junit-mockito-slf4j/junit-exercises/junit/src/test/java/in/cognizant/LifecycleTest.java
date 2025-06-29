package in.cognizant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LifecycleTest {

    private int number;

    @Before
    public void setUp() {
        // Arrange
        number = 10;
        System.out.println("Before each test: number initialized to 10");
    }

    @Test
    public void testAdd() {
        // Act
        int result = number + 5;

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testMultiply() {
        // Act
        int result = number * 2;

        // Assert
        assertEquals(20, result);
    }

    @After
    public void tearDown() {
        System.out.println("After each test: cleaning up");
    }
}

