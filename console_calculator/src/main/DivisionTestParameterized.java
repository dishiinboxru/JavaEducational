package main;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DivisionTestParameterized {
    private double Operand1;
    private double Operand2;
    private double expected;

    public DivisionTestParameterized(double operand1, double operand2, double expected) {
        Operand1 = operand1;
        Operand2 = operand2;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running the division tests...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object [][] {
                {2 , 2 , 1},
               {0 , 2.5 , 0},
                {-2 , 5 , -0.4},
                {-2.5 , 5 , -0.5},
                {-5 , 3.123 , -1.60102466},
                {2.5 , 2 , 1.25},
                {10 , 3.123 , 3.20204931},
                {2.2 , 1.1 , 2},
                //this one requires different delta, thus perhaps parameterising should include deltas too ? )
               {1.23456789 , 2.10987654, 0.585137503},

                {12.5, 10 , 1.25}
        });
    }

    @Test
    public void division() {

        String operation = "/";

        Assert.assertEquals("something wrong with division", expected, ConsoleCalculator.Division(Operand1, Operand2, operation), 0.01);
    }

}
