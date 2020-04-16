package com.shimanskii;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.shimanskii.Operations.Multiplication;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MultiplicationTestParameterized {
    private double Operand1;
    private double Operand2;
    private double expected;

    public MultiplicationTestParameterized(double operand1, double operand2, double expected) {
        Operand1 = operand1;
        Operand2 = operand2;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running the multiplication tests...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object [][] {
                {2 , 2 , 4},
               {-2 , 2.5 , -5},
                {-2.5 , 1 , -2.5},
                {1.23456789 , 2.10987654 , 2.60478583},
                {2.5 , 1.1 , 2.75},
                {-2 , 0 , 0},
                {2 , 0 , 0},
                //this one requires different delta, thus perhaps parameterising should include deltas too ? )
               {-4.94065645841246544e-324d , 2.94065645841246544e-324d , 2.94065645841246544e-324d},
                {2147483647, 2147483647, 4.6116860141324206E18},
                {2.5 , 1 , 2.5},
                {12.5, 10 , 125}
        });
    }

    @Test
    public void multiplication() {

        String operation = "*";

        assertEquals("something wrong with multiplication", expected, Multiplication(Operand1, Operand2, operation), 0.01);
    }

}
