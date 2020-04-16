package com.shimanskii;

import org.junit.Before;
import org.junit.Test;

import static com.shimanskii.Operations.Addition;
import static org.junit.Assert.*;

public class ResulterTest {

    // basically , resulter just processes the filtered output , so it should be checked only for output format, as the operations themselves are checked in separate tests and filtering is done separately as well.
    @Before
    public void setUp() throws Exception { System.out.println("Running resulter  tests..."); }


    @Test
    public void result() {

        String input = "+;2;2";

        assertEquals("something wrong with output format","2+2=4.0", Resulter.result(input) );
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void resultNegativeDelimitersForgotten() {

        String input = "+22";

        assertEquals("something wrong with output format","2+2=4.0", Resulter.result(input) );
    }

    // I though it supposed to be InvalidArguement-something, not IOOBE
    @Test(expected = IndexOutOfBoundsException.class)
    public void resultNegativeWrongOrder() {

        String input = "2;+;2";

        assertEquals("something wrong with output format","2+2=4.0", Resulter.result(input) );
    }

    @Test(expected = NumberFormatException.class)
    public void resultNegativeVerbalInput() {

        String input = "+;two;two";

        assertEquals("something wrong with output format","2+2=4.0", Resulter.result(input) );
    }

}