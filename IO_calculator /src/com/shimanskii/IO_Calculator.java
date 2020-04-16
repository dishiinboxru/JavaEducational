package com.shimanskii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class IO_Calculator {


    //TODO 2 - is output formatting required  (to avoid scientific notation or got for it ?) - yes, regular notation only.



    public static void main(String[] args) throws IOException {

        //converting input txt file into a List in order to proceed.
        List<String> lines = Files.readAllLines(Paths.get("IO_calculator_data.txt"));


//system message
        System.out.println("Calculator is loading... please standby ...");

        //checking if files are read correctly
        System.out.println("reading data to process");

        for (String line : lines) {
            System.out.println(InputFilter.inputFiltered(line));
        }

        //system message
            System.out.println("computing, please standby...");


//processing the output to the file
        String fileData = "Beginning of the IO_Calculator output"+ "\n";
        Files.write(Paths.get("output.txt"), fileData.getBytes());

//calling method to do the computation, while fixing the issues with commas instead of periods
        for (String line : lines) {
            System.out.println(Resulter.result(InputFilter.inputFiltered(line)));

            // a buffer for resulted data
            String appendData = Resulter.result(InputFilter.inputFiltered(line)) + "\n";

// a block for appending data to output file
            File file = new File("output.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(appendData);

            br.close();
            fr.close();

        }

    }
    }






