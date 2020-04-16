package com.shimanskii;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InputFilterTest {

    @Before
    public void setUp() { System.out.println("Running InputFilter tests..."); }

//not sure if it's correct to compare 2 lists with AssertEquals. Though in the resources I've encountered it was considered ok.
    @Test
    public void variousSpacesAndTabsAndCommas() {

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"   1   ","-2","3 ,  5","-0  .  4","   1000,0","0");

        List<String> expectedOutput = new ArrayList<String>();
        Collections.addAll(expectedOutput,"1","-2","3.5","-0.4","1000.0","0");

        // is this one better/different or just the same ?
     //   Assert.assertEquals(expectedOutput , InputFilter.inputFiltered(inputRegular) );

        assertEquals("something wrong with filtering", expectedOutput , InputFilter.inputFiltered(inputRegular) );
    }

}