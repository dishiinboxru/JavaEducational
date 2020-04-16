package com.shimanskii;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ResulterTest {

//       System.out.println("Running resulter  tests...");

    List<String> inputRegular = new ArrayList<String>();

    List<String> inputAllSame = new ArrayList<String>();


    List<String> inputZerosOnly = new ArrayList<String>();


  List<String> inputZerosIncluded = new ArrayList<String>();


//  other tests to populate the test.
//
//    List<String> inputNegativesOnly = new ArrayList<String>();
//        Collections.addAll(inputNegativesOnly,"-1","-2","-3","-4","-10");
//
//    List<String> inputNegativesOnlyAndZeros = new ArrayList<String>();
//        Collections.addAll(inputNegativesOnlyAndZeros,"-1","0","-3","0","-10");
//
//    List<String> inputFloatingPoints = new ArrayList<String>();
//        Collections.addAll(inputFloatingPoints,"0.1","0.02","0.003","0.0004","0.0000010");
//
//    List<String> inputFloatingPointsAndZeros = new ArrayList<String>();
//        Collections.addAll(inputFloatingPointsAndZeros,"0.1","0","0.003","0.0004","0");

    @Before
    public void setUp() {
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");
        Collections.addAll(inputAllSame,"3","3","3","3","3");
        Collections.addAll(inputZerosOnly,"0","0","0","0","0");
        Collections.addAll(inputZerosIncluded,"1","0","3","0","10");

    }

    //those with Lists fail with very creepy output - it says the expected is not equal to actual, while printing two identical lines. Furthermore, if one clicks to see the difference, no difference is highlighted whatsoever.
    @Test
    public void parsingDoubles() {

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1;-2;3.5;-0.4;1000.0;0;1;3");

        List<Double> expectedOutput = new ArrayList<Double>(Arrays.asList(1.0,-2.0,3.5,-0.4,1000.0,0.0,1.0,3.0));


        // is this one better/different or just the same ?
        //   Assert.assertEquals(expectedOutput , InputFilter.inputFiltered(inputRegular) );

        assertEquals("something wrong with filtering", expectedOutput , Resulter.parsingDoubles(inputRegular) );


    }

    @Test
    public void ascending() {

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");

        List<Double> expectedOutput = new ArrayList<Double>(Arrays.asList(-2.0,-0.4,0.0,1.0,3.5,1000.0));


        assertEquals("something wrong with ascending", expectedOutput , Resulter.Ascending(inputRegular) );
    }

    @Test
    public void descending() {

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0.0");

        List<Double> expectedOutput = new ArrayList<Double>(Arrays.asList(1000.0,3.5,1.0,0.0,-0.4,-2.0));

        assertEquals("something wrong with descending", expectedOutput , Resulter.Descending(inputRegular) );
    }

    @Test
    public void max() {

        Double expected = 1000.0;

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");

        assertEquals("something wrong with finding max",expected,Resulter.max(inputRegular));

    }

    @Test
    public void maxAllSame() {

        Double expected = 3.0;

        assertEquals("something wrong with finding max",expected,Resulter.max(inputAllSame));

    }

    @Test
    public void maxZerosOnly() {

        Double expected = 0.0;

        assertEquals("something wrong with finding max",expected,Resulter.max(inputZerosOnly));

    }

    @Test
    public void min() {

        Double expected = -2.0;

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");

        assertEquals("something wrong with finding max",expected,Resulter.min(inputRegular));

    }

    @Test
    public void average() {

        Double expected = 167.01;

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");

        assertEquals("something wrong with finding max",expected,Resulter.average(inputRegular) , 0.01);

    }




}