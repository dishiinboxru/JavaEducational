package com.shimanskii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public  class Resulter {

    public static ArrayList<Double> parsingDoubles(List<String>  input) {

        List<String> filtered = InputFilter.inputFiltered(input);
        ArrayList<Double>  indieElements = new ArrayList<>();

        //going over String List input and turning it into Doubles List
        for (int i = 0; i < filtered.size(); i ++) {
            String line = filtered.get(i);
//splitting by semicolon delimiter
            List<String> temp = new ArrayList<>(Arrays.asList(line.split(";")));


            for (String number : temp) {
            indieElements.add(Double.parseDouble(String.valueOf(number)));
            }

        }
        return indieElements;
    }

//change outputot lists

        public static List<Double> Ascending (List<String>  input){
            List<Double> Ascending = new ArrayList<>(parsingDoubles(input));

            Collections.sort(Ascending);
            return Ascending;

        }

    public static ArrayList<Double> Descending (List<String>  input){
         ArrayList<Double> Descending = new ArrayList<>(parsingDoubles(input));

        Collections.sort(Descending,Collections.reverseOrder());


        return Descending;
    }

    public static Double max (List<String>  input){
        Double max = Descending(input).get(0);
        return max;

    }
    public static Double min (List<String>  input){
        Double min = Ascending(input).get(0);
        return min;

    }
    public static Double average (List<String>  input){
        ArrayList<Double> calculating = new ArrayList<>(parsingDoubles(input));

        Double average = 0d;
        for (Double values : calculating) {
            average += values;
        }

        average =  average / calculating.size();
        return average;
    }



}
