package com.shimanskii;

public class ReporterTest {

//    @org.junit.Test
//    public void outputFileCreation() {
//        Reporter.outputFileCreation();
//    }

    @org.junit.Test
    public void appendingOutput() {
    }

    @org.junit.Test
    public void timeManipulations() {
        Reporter.timeStamp();
        System.out.println(Reporter.timeStamp());
    }
}