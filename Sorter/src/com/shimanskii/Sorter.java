package com.shimanskii;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sorter {
    //TODO 2 - is output formatting required  (to avoid scientific notation or got for it ?) - yes, regular notation only.

    public static void main(String[] args) throws IOException {

        //this block redirects output from console to a file
//        PrintStream out = new PrintStream(
//                new FileOutputStream("sorter_output_of_the_console.txt",true),true);
//        System.setOut(out);

        //converting input txt file into a List in order to proceed.
        List<String> BasicList = Files.readAllLines(Paths.get("/Users/dshimanskii/git/java_internship_shimanskii/Sorter/src/com/shimanskii/Sorter_input_data.txt"));

//system message
        System.out.println("Sorter is loading... please standby ...");

        //checking if files are read correctly
        System.out.println("reading data to process");

        for (int i = 0; i < BasicList.size(); i++) {
            System.out.println(BasicList.get(i));
        }

        //system message
        System.out.println("sorting, please standby...");

//processing the output to the file

        try(FileWriter fr = new FileWriter("Sorter_output.txt")) {


            fr.write("Beginning of the sorter output" + "\n");
//calling method to do the computation, while fixing the issues with commas instead of periods

            // a buffer for resulted data
            //ascended list (for-each loop)
            System.out.println("ascending sort starts");
            fr.write("here comes ascending list" + "\n");
            for (Double line : Resulter.Ascending(InputFilter.inputFiltered(BasicList))) {

                System.out.println(line);
                fr.write(String.valueOf(line));
                fr.write("\n");
            }
// descending list (for each loop)
            System.out.println("descending sort starts");
            fr.write("here comes descending list" + "\n");
            for (Double line : Resulter.Descending(InputFilter.inputFiltered(BasicList))) {

                System.out.println(line);

                fr.write(String.valueOf(line));
                fr.write("\n");
            }

            // block for tracking original data
            System.out.println("original data input  starts");
            fr.write("here comes original data set" + "\n");
            for (String line : BasicList) {

                System.out.println(line);

                fr.write(line);
                fr.write("\n");
            }

            //min,max,avg values input
            System.out.println("Min, max, avg input starts");

            fr.write("here comes certain values " + "\n");

            System.out.println("Maximum is " + Resulter.max(BasicList));
            fr.write("Maximum is " + Resulter.max(BasicList));
            fr.write("\n");

            System.out.println("Minimum is " + Resulter.min(BasicList));
            fr.write("Minimum is " + Resulter.min(BasicList));
            fr.write("\n");

            System.out.println("Average is " + Resulter.average(BasicList));
            fr.write("Average is " + Resulter.average(BasicList));
            fr.write("\n");

            System.out.println("That's the end of sorting procedure. Thank you for using our services !");
            fr.write("That's the end of sorting procedure. Thank you for using our services !");

            //fr.close();
        }
    }
}







