package com.shimanskii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListsOperations {

    ArrayList <String> arrayListUnderTest = new ArrayList<>(FilesAndCollectionsGenerator.generateArrayList());

    //operations for lists
    //b.a

    //removing from the middle
    //1 element
    // 10000 elements
    //50k elements

    //b.b
    //inserting in the beginning
    //1 element
    // 10000 elements
    //50k elements

    // inserting into the middle
    //1 element
    // 10000 elements
    //50k elements

    //inserting in the end
    //1 element
    // 10000 elements
    //50k elements

    //b.c.
    //reading elements from a random location
    //1 element
    // 10000 elements
    //50k elements

    public ArrayListsOperations() {
    }

    //removal block
    public void remove(int iterationSize) {
        for (int i = 0; i < iterationSize; i++) {
            arrayListUnderTest.remove(arrayListUnderTest.size()/2);
        }
    }

    //adding block
    public void add (int iterationSize, String iterationLocation) {
        if (iterationLocation.equals("beginning")){
                for (int i = 0; i < iterationSize; i++) {
                    arrayListUnderTest.add(0,"0");
                }
            }

            if (iterationLocation.equals("middle")){
                for (int i = 0; i < iterationSize; i++) {
                    arrayListUnderTest.add((arrayListUnderTest.size()/2),"0");
                }
            }

            if (iterationLocation.equals("end")){
                for (int i = 0; i < iterationSize; i++) {
                    arrayListUnderTest.add(arrayListUnderTest.size(),"0");
                }
            }
        }

//insertions block
        public void read ( int iterationSize) {
            int random = (int) Math.random();
            for (int i = 0; i < iterationSize; i++) {
               arrayListUnderTest.get(random);
           }
        }
}
