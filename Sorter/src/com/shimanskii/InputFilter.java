package com.shimanskii;

import java.util.ArrayList;
import java.util.List;

public class InputFilter {
    public static List<String>  inputFiltered (List<String> input){

        List<String> filteredList = new ArrayList<String>() ;

        //removing spaces
        for (int i=0; i<input.size(); i++) {
        filteredList.add(input.get(i).replaceAll("\\s+","").replaceAll(",",".").replaceAll("\\n+",""));
        }
        return filteredList;



    }
}
