package com.shimanskii;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FilesAndCollectionsGenerator {

    public static void generateLargeBasicFile()throws IOException {
        try(FileWriter fr = new FileWriter("Collections_performance_basic_input.txt")){

            for (int i =0; i< 5000000; i++){
                fr.write(i + "\n");
            }

        }

        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating large basic file list");
        }
    }

    public static void generateRandomValuesFile()throws IOException {
        try(FileWriter fr = new FileWriter("Collections_performance_random_input.txt")){

            for (int i =0; i< 9000; i++){
                int random = (int)(Math.random()*((288-1)+1))+1;
                fr.write(random + "\n");
            }

        }

        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating random values file list");
        }
    }

    //this block is extremely clumsy, I do believe it's possible to have it done neater

    public static ArrayList<String> generateArrayList () {
        ArrayList<String> arrayListForTest = new ArrayList<String>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/collectionsPerformanceTests/Collections_performance_basic_input.txt")))){
                while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                arrayListForTest.add(data);
            }
        }
    catch (IOException e ){
            e.printStackTrace();
        System.out.println("Error while generating Array list");
    }
        System.out.println("arraylist for tests generated");
        return arrayListForTest;

    }


    public static LinkedList<String> generateLinkedList () {
        LinkedList<String> linkedListForTests = new LinkedList<String>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/collectionsPerformanceTests/Collections_performance_basic_input.txt")))){
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                linkedListForTests.add(data);
            }

        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating Linked list");
        }
        System.out.println("LinkedList for tests has been generated");
        return linkedListForTests;

    }

    public static HashSet<String> generateHashSet () {
        HashSet<String> hashSetForTests = new HashSet<String>();
        FilesAndCollectionsGenerator.populateSet(hashSetForTests);
        return hashSetForTests;

    }

    public static TreeSet<String> generateTreeSet () {
        TreeSet <String> treeSetForTests = new TreeSet<>();
        FilesAndCollectionsGenerator.populateSet(treeSetForTests);
        return treeSetForTests;

    }

    public static LinkedHashSet<String> generateLinkedHashSet () {
        LinkedHashSet<String> linkedHashSetForTests = new LinkedHashSet<String>();
        FilesAndCollectionsGenerator.populateSet(linkedHashSetForTests);
        return linkedHashSetForTests;
    }


    public static Set<String> populateSet ( Set<String> input) {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/collectionsPerformanceTests/Collections_performance_random_input.txt")))){
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                input.add(data);
            }

        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating hashSetForTests");
        }
        return input;

    }



}
