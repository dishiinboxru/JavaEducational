package test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static main.ConsoleCalculator.Addition;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdditionTestParameterized {

    private double Operand1;
    private double Operand2;
    private double expected;

    public AdditionTestParameterized(double operand1, double operand2, double expected) {
        Operand1 = operand1;
        Operand2 = operand2;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running the additions tests...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object [][] {
                {2 , 2 , 4},
                {-2 , 2.5 , 0.5},
                {2.5 , 1 , 3.5},
                {2.5 , 1 , 3.5},
                {2.5 , 1.6 , 4.1},
                {-2 , 0 , -2},
                {0 , 2 , 2},
                {-2356 , 2355 , -1},
                {2147483647, -2147483647, 0},
                {-2.5 , 1 , -1.5},
                {12, 12 , 24}
        });
    }

    @org.junit.Test
    public void addition() {
//        double a = 2;
//        double b = 2;
        String operation = "+";

        assertEquals("something wrong with addition", expected, Addition(Operand1, Operand2, operation), 0.01);
    }

}
