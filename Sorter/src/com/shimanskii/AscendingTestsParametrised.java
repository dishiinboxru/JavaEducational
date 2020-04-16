package com.shimanskii;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;
import java.util.stream.Stream;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AscendingTestsParametrised {

    private List<Double> expected;
    private List<String> input;

    public AscendingTestsParametrised(List<Double> expected, List<String> input) {
        this.expected = expected;
        this.input = input;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running the max parametrised tests...");
    }

    //as for 13:00 - doesn't work - says argument type mismatch. tried changing Object to Collections and to Lists without success
    //worked after changing the output of method to List, as currently Arrays.asList actually returns something static and thus inoperable with current parametrised test

    @Parameters
    //
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new List[][]{
                {(Arrays.asList(-2.0,-0.4,0.0,1.0,3.5,1000.0)), (Arrays.asList("1","-2","3.5","-0.4","1000.0","0"))},
                {(Arrays.asList(-2.0,-0.4,0.0,1.0,3.5,1001.0)), (Arrays.asList("1","-2","3.5","-0.4","1001.0","0"))}

        });
    }



    @Test
    public void ascending() {

//        List<String> inputRegular = new ArrayList<String>();
//        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");
//
//        List<Double> expectedOutput = new ArrayList<Double>(Arrays.asList(-2.0,-0.4,0.0,1.0,3.5,1000.0));


        assertEquals("something wrong with ascending", expected , Resulter.Ascending(input) );
    }
}
