package com.shimanskii;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Reporter {

//file creation and appending is done in a single block due to enabling timeStamping in file name
//    public static void outputFileCreation() {
//
//
//        try (FileWriter fr = new FileWriter("Maps_intersection_results_" + timeStamp()+ ".txt")) {
//            fr.write("Maps intersection search commencing..." +"\n");
//            //fr.write("Performance tests have finished successfully. Now you can tell which Collection is the fastest !");
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }

    public static void appendingOutput (LinkedList<String> messages){
        //common time stamp
        String timeStamp = timeStamp();

        //generating a file
        try (FileWriter fr = new FileWriter("Maps_intersection_results_" + timeStamp + ".txt")) {
            fr.write("Maps intersection search commencing..." +"\n");

        } catch (IOException e){
            e.printStackTrace();
        }
        //appending data to file
        try (FileWriter fr = new FileWriter("Maps_intersection_results_" + timeStamp + ".txt", true)) {

            for (String message : messages){
                fr.write(message + "\n");
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

        //closing system statement
        try (FileWriter fr = new FileWriter("Maps_intersection_results_" + timeStamp + ".txt", true)) {

                fr.write("intersections search finished successfully" + "\n");

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String timeStamp() {
        String timeStamp;
        Date date = new Date();
        int currentDate = date.getDate();
        int currentMonth = date.getMonth();
        int hours = date.getHours();
        int minutes = date.getMinutes();
      //  System.out.println(" first version " + currentDate + currentMonth + hours + minutes);
        long time = date.getTime();
      //  System.out.println("second version with time" + time);
        timeStamp = "time" + currentDate + currentMonth + hours + minutes;

        return timeStamp;


    }
}
