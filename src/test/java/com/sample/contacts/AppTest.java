package com.sample.contacts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest{ 
	
	@Test
    void testApp() {
        assertTrue(true, "This test should always pass");
    }

    @Test
    void testAddition() {
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
    }
}