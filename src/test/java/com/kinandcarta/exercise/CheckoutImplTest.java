package com.kinandcarta.exercise;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckoutImplTest {
    @Test
    public void testWithoutDiscounts() {

        // Items 0001 and 0003 together should come to £28.94.  As this is returned as an int,
        // it will be 2894.  Notice that we are creating a new instance of the implementation
        // class (CheckoutImpl), but the variable's type is the interface that that class
        // implements (Checkout).
        Checkout checkout = new CheckoutImpl();
        checkout.scan(Arrays.asList("0001", "0003"));
        
        // Use the junit method to check that we got the correct total.  The last parameter in this
        // call is the string that will only be displayed when the first two parameters aren't equal.
        assertEquals(2894, checkout.getTotal(), "Total incorrect");
    }

    @Test
    public void testWithoutDiscounts2() {
        Checkout checkout = new CheckoutImpl();
        checkout.scan(Arrays.asList("0003", "0003", "0003"));
        assertEquals(1197, checkout.getTotal(), "Total incorrect");
    }

    @Test
    public void testWithoutItems() {
        // Empty array should return a total cost of zero.
        Checkout checkout = new CheckoutImpl();
        checkout.scan(Arrays.asList());
        assertEquals(0, checkout.getTotal(), "Total incorrect");
    }

    @Test
    public void testExamplesFromExerciseDescription() {

        Checkout checkout1 = new CheckoutImpl();
        checkout1.scan(Arrays.asList("0001", "0001", "0002", "0003"));
        assertEquals(10347, checkout1.getTotal(), "Total incorrect");

        Checkout checkout2 = new CheckoutImpl();
        checkout2.scan(Arrays.asList("0001", "0001", "0001"));
        assertEquals(6897, checkout2.getTotal(), "Total incorrect");

        Checkout checkout3 = new CheckoutImpl();
        checkout3.scan(Arrays.asList("0001", "0001", "0002", "0003"));
        assertEquals(10347, checkout3.getTotal(), "Total incorrect");
    }
}
