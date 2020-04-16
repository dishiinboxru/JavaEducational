package main;

public class ConsoleCalculator {

    //method-encapsulated version
    public static double Addition (double a, double b, String operation) {
        double output = a + b;

        System.out.println(a +" "+ operation +" "+ b + " = " + output);
        return output;
    }

    public static double Substraction (double a, double b, String operation) {
        double output = a - b;

        System.out.println(a +" "+ operation +" "+ b + " = " + output);
        return output;
    }

    public static double Multiplication (double a, double b, String operation) {
        double output = a * b;

        System.out.println(a +" "+ operation +" "+ b + " = " + output);
        return output;
    }

    public static double Division (double a, double b, String operation) {
        double output = a / b;

        System.out.println(a +" "+ operation +" "+ b + " = " + output);
        return output;
    }

    //TODO 1 -- shall a separate output method and operationSelector be created or current structure with sout is sufficient ?

    //TODO 2 - is output formatting required  (to avoid scientific notation or got for it ?)



    public static void main(String[] args) {

//system message
        System.out.println("Calculator is computing... please standby ...");

//parsing command line arguments
        double Operand1= Double.parseDouble(args[1]);
        double Operand2= Double.parseDouble(args[2]);
        String operation = args[0];

        if (operation.equals("+")) {
            Addition(Operand1,Operand2,operation) ;
        }

        if (operation.equals("-")) {
            Substraction(Operand1,Operand2,operation);
        }

        if (operation.equals("*")) {
            Multiplication(Operand1,Operand2,operation);
        }

        if (operation.equals("/")) {
            Division(Operand1,Operand2,operation);
        }

    }


}



