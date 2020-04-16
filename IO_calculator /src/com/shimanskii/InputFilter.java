package com.shimanskii;

public class InputFilter {
    public static String inputFiltered (String input){

        //removing spaces
        String spacesRemoved = input.replaceAll("\\s+","");
        //replacing commas with periods
        String punctuiationFixed = spacesRemoved.replace(",",".");
        return punctuiationFixed;

//technically, both lines can be done in one, but IMHO that reduces readability of the code

    }
}
