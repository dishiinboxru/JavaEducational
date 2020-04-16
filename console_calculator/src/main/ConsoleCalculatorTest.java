package main;

import org.junit.Assert;

public class ConsoleCalculatorTest {
    @org.junit.Before
    public void setup() {
        System.out.println("Running basic tests...");
    }

    @org.junit.Test
    public void addition() {
        double a = 2;
        double b = 2;
        String operation = "+";

        Assert.assertEquals("something wrong with addition",4.0 , ConsoleCalculator.Addition(a, b, operation) , 0);
       // fail ("this test is to be implemented");

    }

    @org.junit.Test
    public void substraction() {

        double a = 10;
        double b = 2;
        String operation = "-";

        Assert.assertEquals(8 , ConsoleCalculator.Substraction(a, b, operation) , 0);
        //fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void multiplication() {

        double a = 6;
        double b = 2;
        String operation = "*";

        Assert.assertEquals(12 , ConsoleCalculator.Multiplication(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }

    @org.junit.Test
    public void division() {

        double a = 2;
        double b = 2;
        String operation = "/";

        Assert.assertEquals(1 , ConsoleCalculator.Division(a, b, operation) , 0);
       // fail ("this test is to be implemented");
    }
}