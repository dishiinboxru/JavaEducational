package com.shimanskii;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.shimanskii.MergeSort.printArray;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MergeSortParametrisedTests {

   // private String errorMessage;
    private Double expectedSortedArr[];
    private Double[] arr;

    //somehow initialised an instance ?

//
//    public MergeSortParametrisedTests(String errorMessage, Double[] expectedSortedArr, Double[] arr) {
//      //  this.errorMessage = errorMessage;
//        this.expectedSortedArr = expectedSortedArr;
//        this.arr = arr;
//    }

    public MergeSortParametrisedTests(Double[] expectedSortedArr, Double[] arr) {
        this.expectedSortedArr = expectedSortedArr;
        this.arr = arr;
    }

    @org.junit.Before
    public void setup() {
        System.out.println("Running Merge sorting parametrised test...");
    }

    @org.junit.After
    public void tearDown() {
        System.out.println("Running Merge sorting parametrised test completed..." + "\n");
    }

    @Parameters
    //
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Double[][][]{
                //expected , input
                {{-2.0,-0.4,0.0,1.0,3.5,1000.0},        {0.0,-2.0,-0.4,1.0,3.5,1000.0}},//odd case
                {{-2.0,-0.4,0.0,1.0,3.5,100d,1000.0},   {0.0,-2.0,100d,-0.4,1.0,3.5,1000.0}},//even case
                {{-1000.0,-3.5,-2.0,-1.0,-0.4},         {-2.0,-0.4,-1.0,-3.5,-1000.0} },//negatives only
                {{-2.2,-0.4,3.5,6.6,7.7},               {-2.2,-0.4,7.7,3.5,6.6}},//floating point only
                {{-2.0,-0.4,0.0,0d,0d,1.0,3.5,1000.0},  {0.0,-2.0,-0.4,1.0,0d,3.5,1000.0,0d}},// several zeros
                {{-0.9,-0.4,0.1,0.3,0.5,0.9},           {0.9,-0.4,0.5,0.3,0.1,-0.9}},//decimal values only
                {{-2.0,-0.4,0.0,1.0,3.5,1000.0},        {-2.0,-0.4,0.0,1.0,3.5,1000.0}},//already sorted array
                {{-2.0,-2.0,-2.0,3.5,3.5,3.5},          {-2.0,-2.0,3.5,3.5,3.5,-2.0}},//most values are duplicated
                {{-2.0,-0.4,0.0,1.0,3.5,1000.0},        {1000.0,3.5,1.0,0.0,-0.4,-2.0}}, //reverse sorted
                {{1000.0},                              {1000.0}},//single element
                {{2.2,2.2,2.2,2.2,2.2,2.2},             {2.2,2.2,2.2,2.2,2.2,2.2}},//same value array (performance test required as well)
                {{-1.79769313486231570e+308d,-2.0,-0.4,0.0,4.94065645841246544e-324d,1.0,3.5,1000.0,1.79769313486231570e+308d}, {0.0,-2.0,-0.4,1.0,3.5,4.94065645841246544e-324d,1.79769313486231570e+308d,-1.79769313486231570e+308d,1000.0}},//doubles limits



        });
    }

    @org.junit.Test
    public void sortMergeBasic() {

     //   Double arr[] = {12d, 11d, 13d, 5d, 6d, 7d, 10000d, -9d, 0.9988899, 0.0 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);

    //    Double expectedSortedArr[] = {-9.0, 0.0, 0.9988899, 5.0, 6.0, 7.0, 11.0, 12.0, 13.0, 10000.0 };

        String errorMessage="Error while mergeSorting a basic array of doubles";

        assertArrayEquals(errorMessage,expectedSortedArr,arr);
    }

}
