package com.shimanskii;

public class BubleSort {

    static void bubbleSort(Double[] arr) {
        int n = arr.length;
        Double temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }
    public static void main(String[] args) {
        Double arr[] ={3d,60d,35d,2d,45d,320d,5d, -100d , 767678d, 0d, 7967679689789734534534534545345435342223445234324324322343242324444444322323232323d};

        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSort(arr);//sorting array elements using bubble sort

        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
