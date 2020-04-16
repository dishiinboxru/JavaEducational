package com.shimanskii;

import static com.shimanskii.MergeSort.printArray;
import static org.junit.Assert.*;

public class MergeSortTest {

    @org.junit.Test
    public void sortMergeBasic() {

        Double arr[] = {12d, 11d, 13d, 5d, 6d, 7d, 10000d, -9d, 0.9988899, 0.0 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);

        Double expectedSortedArr[] = {-9.0, 0.0, 0.9988899, 5.0, 6.0, 7.0, 11.0, 12.0, 13.0, 10000.0 };

        String errorMessage="Error while mergeSorting a basic array of doubles";

        assertArrayEquals(errorMessage,expectedSortedArr,arr);
    }

    @org.junit.Test
    public void sortMergePerformanceSameValuesVsDiffValues() {
        MergeSort ob = new MergeSort();
        Double arr[] = {12d, 12d,12d,12d,12d,12d, };
        Double arrDiff[] = {-1.79769313486231570e+308d,0.0,4.94065645841246544e-324d,3.5,1000.0,1.79769313486231570e+308d};
//measuring time of sameValues
        long startNanoSame = System.nanoTime();
//        System.out.println("Given Array");
//        printArray(arr);
        ob.sort(arr, 0, arr.length-1);

        long endNanoSame = System.nanoTime();
        long totalNanoSame= endNanoSame - startNanoSame;
        System.out.println("Merge sort of 6 same elements took " + totalNanoSame + " nanoseconds");


        //measuring time of different values

        long startNanoDiff = System.nanoTime();
//        System.out.println("Given Array");
//        printArray(arrDiff);
      //  MergeSort ob = new MergeSort();
        ob.sort(arrDiff, 0, arr.length-1);

        long endNanoDiff = System.nanoTime();
        long totalNanoDiff= endNanoDiff - startNanoDiff;
        System.out.println("While Merge sort of 6 totally different  elements took " + totalNanoDiff + " nanoseconds");
    }

    @org.junit.Test
    public void sortMergeEmptyArr() {

        Double arr[] = new Double[0];

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);

        Double expectedSortedArr[] = new Double[0];

        String errorMessage="Error while mergeSorting a empty array of doubles";

        assertArrayEquals(errorMessage,expectedSortedArr,arr);
    }

}