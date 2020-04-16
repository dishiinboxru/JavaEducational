package com.shimanskii;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SourcesGenerator {


    public static String generatingRandomStringBounded() {

        int leftLimit = 65; // sign !-33, 65-A
        int rightLimit = 122; // letter 'z' ( plus 6 special characters in between included

//TODO - update value to 13 when finished

        //for testing purposes it's shortened to 2 from 13
        int targetStringLength = 4;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public static long generateRandomNumber() {
      //boundaries

        //TODO 2 - decrease to 99999  (as now increased to make number of intersections human readable)
        int max = 99999123;
        int min = 1;

        long randomNumber = (long) (Math.random() * ((max - min) + 1)) + min;
        return randomNumber;
    }

    public static void generateFileForMap()  {
        try (FileWriter fr = new FileWriter("Maps_random_input.txt")) {

            for (int i = 0; i < 17000; i++) {
                long random = SourcesGenerator.generateRandomNumber();
                String text = SourcesGenerator.generatingRandomStringBounded();


                fr.write(text + " " + random + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while generating random key+values file list");
        }
    }

    public static void generateTwoFilesForTwoMaps()  {
        try (FileWriter fr = new FileWriter("Maps_random_input_alpha.txt")) {

            for (int i = 0; i < 17000; i++) {
                long random = SourcesGenerator.generateRandomNumber();
                String text = SourcesGenerator.generatingRandomStringBounded();


                fr.write(text + " " + random + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while generating random key+values file list alpha");
        }

        try (FileWriter fr = new FileWriter("Maps_random_input_betta.txt")) {

            for (int i = 0; i < 17000; i++) {
                long random = SourcesGenerator.generateRandomNumber();
                String text = SourcesGenerator.generatingRandomStringBounded();


                fr.write(text + " " + random + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while generating random key+values file list betta ");
        }
    }

    public static LinkedHashMap <String, Long > populateMap() {
        LinkedHashMap <String, Long > mapAlpha = new LinkedHashMap<>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/p4_maps/Maps_random_input.txt")))){
            scanner.useDelimiter(" ");
            int iteration = 0;
            while (scanner.hasNextLine()){

           //     System.out.println("insertion #" + iteration);
                String key = scanner.next();
           //     System.out.println(key);
                scanner.skip(scanner.delimiter());
           //     System.out.println("delimiter reached");
                Long value = Long.parseLong(scanner.nextLine());
            //    System.out.println(value);

                mapAlpha.put(key,value);

                iteration ++;
            }

        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating a map list");
        }
        System.out.println("SPECIFY-TYPE-Map for tests has been generated");
        return mapAlpha;

    }

    public static void populateTwoMaps(LinkedHashMap <String, Long > alphaMap, LinkedHashMap <String, Long > bettaMap) {

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/p4_maps/Maps_random_input_alpha.txt")))){
            scanner.useDelimiter(" ");

            while (scanner.hasNextLine()){

                String key = scanner.next();
                scanner.skip(scanner.delimiter());
                Long value = Long.parseLong(scanner.nextLine());
                alphaMap.put(key,value);
            }

        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating a map alpha");
        }
        System.out.println("LinkedHashMap Alpha for tests has been generated");

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/dshimanskii/git/java_internship_shimanskii/p4_maps/Maps_random_input_betta.txt")))){
            scanner.useDelimiter(" ");

            while (scanner.hasNextLine()){

                String key = scanner.next();
                scanner.skip(scanner.delimiter());
                Long value = Long.parseLong(scanner.nextLine());
                bettaMap.put(key,value);
            }

        }
        catch (IOException e ){
            e.printStackTrace();
            System.out.println("Error while generating a map betta");
        }
        System.out.println("LinkedHashMap Betta for tests has been generated");
    }
}
