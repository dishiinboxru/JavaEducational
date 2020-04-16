package com.shimanskii;

import static com.shimanskii.MergeSort.printArray;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Double arr[] = {12d, 11d, 13d, 5d, 6d, 7d, 10000d, -9d, 0.9988899, 0.0 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
