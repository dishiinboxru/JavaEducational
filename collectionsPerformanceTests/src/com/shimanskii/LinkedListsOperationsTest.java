package com.shimanskii;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LinkedListsOperationsTest {

    private String iterationType;
    private int iterationSize;
    private String iterationLocation;

    public LinkedListsOperationsTest(String iterationType, int iterationSize, String iterationLocation) {
        this.iterationType = iterationType;
        this.iterationSize = iterationSize;
        this.iterationLocation = iterationLocation;
    }
//default constructor
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object [][]
//    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object [][] {
                {"add" , 1 , "end"},
                {"add" , 10000 , "end"},
                {"add" , 50000 , "end"},

                {"add" , 1 , "beginning"},
                {"add" , 10000 , "beginning"},
                {"add" , 50000 , "beginning"},

                //seems to have issues with middle insertion and random too. let's try to run heavy loads in the end.6
                {"add" , 1 , "middle"},
                {"add" , 2 , "middle"},
                {"add" , 5 , "middle"},

                {"remove" , 1 , "middle"},
                {"remove" , 2 , "middle"},
                {"remove" , 5 , "middle"},
//12
                {"read" , 1 , "end"},
                {"read" , 2 , "end"},
                {"read" , 15 , "end"},

                //full loads block 15
                {"add" , 1 , "middle"},
                {"add" , 10000 , "middle"},
                {"add" , 50000 , "middle"},
//18
                {"remove" , 1 , "middle"},
                {"remove" , 10000 , "middle"},
                {"remove" , 50000 , "middle"},
//21
                {"read" , 1 , "end"},
                {"read" , 10000, "end"},
                {"read" , 50000 , "end"},


             //   {12.5, 10 , 1.25}
        });
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("LinkedList test initiated");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("LinkedList test finished");
    }

    @Test
    public void operation() {
       LinkedListsOperations test2 = new LinkedListsOperations();
        long startNano = System.nanoTime();
        test2.operation( iterationType,  iterationSize,  iterationLocation);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type "+ iterationType+ " of " +iterationSize +" elements from the "+iterationLocation+" of an LinkedList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}