package com.shimanskii;

import java.util.HashSet;
import java.util.Set;

public class SetsGenerator <T>{

    public static void main(String[] args) {


    }


    public static Set<CustomObject> generateAlphaSet() {

        CustomObject john = new CustomObject("John",2,18,80,12.12);

        CustomObject jill = new CustomObject("Jill",1,18,80,12.12);

        CustomObject ivan = new CustomObject("John",3,18,80,13.12);
        Set<CustomObject> alphaSet = new HashSet<>();
              alphaSet.add(john);
             alphaSet.add(ivan);
        alphaSet.add(jill);

        return alphaSet;

    }

    public static Set<CustomObject> generateBetaSet() {

        CustomObject john = new CustomObject("John",2,18,80,12.12);

        CustomObject jill = new CustomObject("Jill",1,18,80,12.12);

        Set<CustomObject> betaSet = new HashSet<>();

        return betaSet;

    }







}
