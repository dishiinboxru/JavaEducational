package com.shimanskii;

import static com.shimanskii.Operations.*;
import static org.junit.Assert.*;

public class IO_CalculatorTest {
    @org.junit.Before
    public void setup() {
        System.out.println("Running basic tests...");
    }

    @org.junit.Test
    public void addition() {
        double a = 2;
        double b = 2;
        String operation = "+";

        assertEquals("something wrong with addition",4.0 , Addition(a, b, operation) , 0);
       // fail ("this test is to be implemented");

    }

    @org.junit.Test
    public void substraction() {

        double a = 10;
        double b = 2;
        String operation = "-";

        assertEquals(8 , Substraction(a, b, operation) , 0);
        //fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void multiplication() {

        double a = 6;
        double b = 2;
        String operation = "*";

        assertEquals(12 , Multiplication(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void division() {

        double a = 2;
        double b = 2;
        String operation = "/";

        assertEquals(1 , Division(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }
}