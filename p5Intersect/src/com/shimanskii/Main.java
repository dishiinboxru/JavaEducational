package com.shimanskii;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

        CustomObject john = new CustomObject("John",007,18,80,12.12);

        System.out.println(john.hashCode());

        CustomObject jill = new CustomObject("Jill",007,18,80,12.12);

        System.out.println(jill.hashCode());

        CustomObject ivan = new CustomObject("John",007,18,80,12.12);

        System.out.println(ivan.hashCode());

        Intersect test1 = new Intersect();


        Set<CustomObject> alphaSet = new HashSet<>();

        Set<CustomObject> betaSet = new HashSet<>();



        betaSet.add(ivan);
   //     betaSet.add(jill);

        System.out.println("List of intersected Custom objects is below ");
//
//            for (T item : test1.intersect(alphaSet, betaSet)) {
//                System.out.println( item);
//            }

        System.out.println(test1.intersect(alphaSet, betaSet));
    }
}
