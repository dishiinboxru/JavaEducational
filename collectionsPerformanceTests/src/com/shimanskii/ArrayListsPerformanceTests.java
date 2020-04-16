package com.shimanskii;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class ArrayListsPerformanceTests {

    @Test
    public void remove1() {
        int iterationSize = 1;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.remove(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type removal of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void remove10000() {
        int iterationSize = 10000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.remove(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type removal of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void remove50000() {
        int iterationSize = 50000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.remove(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type removal of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    @Test
    public void addEnd50000() {
        int iterationSize = 50000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"end");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the end of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void addEnd10000() {
        int iterationSize = 10000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"end");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the end of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void addEnd1() {
        int iterationSize = 1;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"end");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the end of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addBeginning10000() {
        int iterationSize = 10000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"beginning");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the beginning of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addBeginning50000() {
        int iterationSize = 50000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"beginning");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the beginning of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addBeginning1() {
        int iterationSize = 1;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"beginning");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in  the beginning of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addMiddle10000() {
        int iterationSize = 10000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"middle");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addMiddle50000() {
        int iterationSize = 50000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"middle");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void addMiddle1() {
        int iterationSize = 1;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();

        test1.add(iterationSize,"middle");

        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type insertion of " +iterationSize +" elements in the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void read50000() {

        int iterationSize = 50000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.read(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type read of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void read10000() {

        int iterationSize = 10000;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.read(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type read of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void read1() {

        int iterationSize = 1;
        ArrayListsOperations test1 = new ArrayListsOperations();

        long startNano = System.nanoTime();
        test1.read(iterationSize);
        long endNano = System.nanoTime();
        long totalNano= endNano - startNano;

        try (FileWriter fr = new FileWriter("Collections_performance_results.txt", true)) {

            fr.write("iteration type read of " +iterationSize +" elements from the middle of an ArrayList took " + totalNano + " Nanoseconds." + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}