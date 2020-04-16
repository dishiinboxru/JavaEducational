package com.shimanskii;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ResulterTest_JUnit5 {

    @Test
    void ascending() {

        List<String> inputRegular = new ArrayList<String>();
        Collections.addAll(inputRegular,"1","-2","3.5","-0.4","1000.0","0");

        List<Double> expectedOutput = new ArrayList<Double>(Arrays.asList(-2.0,-0.4,0.0,1.0,3.5,1000.0));


        assertEquals("something wrong with ascending", expectedOutput , Resulter.Ascending(inputRegular) );
    }
}