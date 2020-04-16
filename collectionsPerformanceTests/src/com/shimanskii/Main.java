package com.shimanskii;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //making input files
        FilesAndCollectionsGenerator.generateLargeBasicFile();
        FilesAndCollectionsGenerator.generateRandomValuesFile();

        //generating output file
        try (FileWriter fr = new FileWriter("Collections_performance_results.txt")) {
            fr.write("Collections performance tests starting now..." +"\n");
            //fr.write("Performance tests have finished successfully. Now you can tell which Collection is the fastest !");
        }

//please run tests Manually to see the output of the results in the file



        //for Sets tests


        //for lists tests

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

        //removal tests (3 items)
//        ArrayListsOperations test1 = new ArrayListsOperations("remove",1, "middle");
//        ArrayListsOperations test2 = new ArrayListsOperations("remove",10000, "middle");
//        ArrayListsOperations test3 = new ArrayListsOperations("remove",50000, "middle");
//
//        //reading tests ( 3 items)
//        ArrayListsOperations test4 = new ArrayListsOperations("read",1, "random");
//        ArrayListsOperations test5 = new ArrayListsOperations("read",10000, "random");
//        ArrayListsOperations test6 = new ArrayListsOperations("read",50000, "random");
//
//        //insertion tests ( 9 items)
//
//        ArrayListsOperations test7 = new ArrayListsOperations("add",1, "middle");
//        ArrayListsOperations test8 = new ArrayListsOperations("add",10000, "middle");
//        ArrayListsOperations test9 = new ArrayListsOperations("add",50000, "middle");
//
////        ArrayListsOperations insertOneBeginning = new ArrayListsOperations("add",1, "beginning");
//////        ArrayListsOperations insertTennerBeginning = new ArrayListsOperations("add",10000, "beginning");
////        ArrayListsOperations insertFiftyBeginning = new ArrayListsOperations("add",50000, "beginning");
//
//        ArrayListsOperations test10 = new ArrayListsOperations("add",1, "end");
//        ArrayListsOperations test11 = new ArrayListsOperations("add",10000, "end");
//        ArrayListsOperations test12 = new ArrayListsOperations("add",50000, "end");


            //output the data to files with results




        }
    }

