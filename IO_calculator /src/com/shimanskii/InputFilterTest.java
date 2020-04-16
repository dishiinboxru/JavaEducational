package com.shimanskii;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputFilterTest {

    @Before
    public void setUp() { System.out.println("Running InputFilter tests..."); }


    @Test
    public void variousSpacesAndTabs() {

        String input = "+   ;2    ;   222 222";

        assertEquals("something wrong with filtering","+;2;222222", InputFilter.inputFiltered(input) );
    }

    @Test
    public void commasInsteadOfPeriods() {

        String input = "-;1,5;0,5";

        assertEquals("something wrong with filtering","-;1.5;0.5", InputFilter.inputFiltered(input) );
    }

    @Test
    public void slashShielding() {

        String input = "/;1,5;0,5";

        assertEquals("something wrong with filtering","/;1.5;0.5", InputFilter.inputFiltered(input) );
    }

    //not sure here about methodology, as on one hand, you supposed to check one thing at a time . However, this one can be viewed as a larger scale test , can't it?
    @Test
    public void slashShieldingAndSpacingAndCommas() {

        String input = "/;    1 , 5; 0 , 5 ";

        assertEquals("something wrong with filtering","/;1.5;0.5", InputFilter.inputFiltered(input) );
    }
}