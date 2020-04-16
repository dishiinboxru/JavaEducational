package com.shimanskii;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SetsStorageOrderTest {



    @Test
    public void setsOrderingTest() {
        System.out.println("that's a hashSet , order supposed to be random");
        System.out.println(FilesAndCollectionsGenerator.generateHashSet().size());
        System.out.println(FilesAndCollectionsGenerator.generateHashSet().toString());

        System.out.println("this is a Tree set, order is supposed to be in alphabetical A...z order.");
        System.out.println(FilesAndCollectionsGenerator.generateTreeSet().toString());
        System.out.println(FilesAndCollectionsGenerator.generateTreeSet().size());

        System.out.println("That's a LinkedHashSet, order is supposed to be the same order as items are inserted, thus same to random_input file");
        System.out.println(FilesAndCollectionsGenerator.generateLinkedHashSet().size());
        System.out.println(FilesAndCollectionsGenerator.generateLinkedHashSet().toString());

        System.out.println("here goes the original file");

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/collectionsPerformanceTests/Collections_performance_random_input.txt")))){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating Array list");
        }

    }
}