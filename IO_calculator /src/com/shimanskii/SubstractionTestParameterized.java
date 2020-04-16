package com.shimanskii;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


import static com.shimanskii.Operations.Substraction;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SubstractionTestParameterized {
    private double Operand1;
    private double Operand2;
    private double expected;

    public SubstractionTestParameterized(double operand1, double operand2, double expected) {
        Operand1 = operand1;
        Operand2 = operand2;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running the substraction tests...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object [][] {
                {2 , 2 , 0},
               {-2 , 2.5 , -4.5},
                {-2.5 , 1 , -3.5},
                {1.79769313486231570e+308d, 1.79769313486231570e+308d , 0},
                {2.5 , 1.6 , 0.9},
                {-2 , 0 , -2},
                {2 , 0 , 2},
               {-4.94065645841246544e-324d , 2.94065645841246544e-324d , 2.94065645841246544e-324d},
                {2147483647, 2147483647, 0},
                {2.5 , -1 , 3.5},
                {12, 10.5 , 1.5}
        });
    }

    @Test
    public void substraction() {

        String operation = "-";

        assertEquals("something wrong with substraction", expected, Substraction(Operand1, Operand2, operation), 0.01);
    }

}
