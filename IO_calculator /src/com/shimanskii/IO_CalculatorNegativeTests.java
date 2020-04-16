package com.shimanskii;

import org.junit.Test;

import static com.shimanskii.Operations.*;
import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/* Lots of questions in here
1- division by zero with double actually results in infinity, not Exception. How to proceed ? I guess a test case with Infinitive values as expected will do. Otherwise, the whole calculator logic should include wrapping Double 0 into Integer 0 thus causing exception to be thrown.

        2- same stuff with multiplications over the doubles range.

        3 - however, when dividing smallest floating point double by 2, result is 0.... shall 0 be expected in that case ? or anything less than min. floating point ?

        4 - 0Infinity for substraction */

public class IO_CalculatorNegativeTests {
    @org.junit.Before
    public void setup() {
        System.out.println("Running the negative  tests...");
    }

    @Test // not sure how to proceed with this one, as gives Infinity as the answer...(expected = AssertionError.class)
    public void divisionByZero() throws Exception{
        double a = 2;
        double b = 0;
        String operation = "/";

        assertEquals("something wrong with division by zero",Infinity , Division(a, b, operation) , 0);
       // fail ("this test is to be implemented");

    }

    @org.junit.Test//
    public void substractionOutOfBounds() {

        double a = -1.79769313486231570e+308d;
        double b = 1.79769313486231571e+308d;
        String operation = "-";

        assertEquals(-Infinity , Substraction(a, b, operation) , 0);
        //fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void multiplicationOutOfBounds() {

        double a = 1.79769313486231570e+308d;
        double b = 1.79769313486231571e+308d;
        String operation = "*";

        assertEquals("something wrong with multiplication at maximum positive range", Infinity , Multiplication(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void additionOutOfBounds() {

        double a = 1.79769313486231570e+308d;
        double b = 1.79769313486231571e+308d;
        String operation = "+";

        assertEquals("something wrong with multiplication at maximum positive range", Infinity , Addition(a, b, operation) , 0);
        // fail ("this test is to be implemented");
    }
    @org.junit.Test
    public void divisionOutOfBounds() {

        double a = 4.94065645841246544e-324d;
        double b = 2;
        String operation = "/";

        assertEquals(0 , Division(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }
}