package com.shimanskii;

import java.util.ArrayList;

public  class Resulter {

    public static String result(String input) {
        ArrayList<String> indieElements = new ArrayList<String> ();


//splitting by semicolon delimiter
        for (String retval : input.split(";")) {
            indieElements.add(retval);
        }


        if (indieElements.get(0).equals("+")) {
            indieElements.add(String.valueOf(Operations.Addition(Double.parseDouble(indieElements.get(1)),Double.parseDouble(indieElements.get(2)),indieElements.get(0))));
            System.out.println("addition initiated");
        }

        else if (indieElements.get(0).equals("-")) {
            System.out.println("substraction initiated");
            indieElements.add(String.valueOf(Operations.Substraction(Double.parseDouble(indieElements.get(1)),Double.parseDouble(indieElements.get(2)),indieElements.get(0))));
        }

        else if (indieElements.get(0).equals("*")) {
            System.out.println("multiplication initiated");
            indieElements.add(String.valueOf(Operations.Multiplication(Double.parseDouble(indieElements.get(1)),Double.parseDouble(indieElements.get(2)),indieElements.get(0))));
        }

        else if (indieElements.get(0).equals("/")) {
            System.out.println("division initiated");
            indieElements.add(String.valueOf(Operations.Division(Double.parseDouble(indieElements.get(1)),Double.parseDouble(indieElements.get(2)),indieElements.get(0))));
        }

        String output = indieElements.get(1) + indieElements.get(0) + indieElements.get(2) + "=" + indieElements.get(3);

        return output;}
}
