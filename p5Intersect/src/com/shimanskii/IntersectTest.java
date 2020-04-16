package com.shimanskii;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IntersectTest {

    @org.junit.Test
    public void intersectCustomObjects() {

        Intersect test1 = new Intersect();

        assertEquals("something wrong with basic sets intersection", SetsGenerator.generateBetaSet(), test1.intersect(SetsGenerator.generateBetaSet(),SetsGenerator.generateAlphaSet()));


    }

    @org.junit.Test
    public void intersectWrapperObjectsSameType() {

        Set<Double> alphaSet = new LinkedHashSet<>();
        alphaSet.add(12.12);
        alphaSet.add(12.11);
        alphaSet.add(12.10);

        Set<Double> betaSet = new LinkedHashSet<>();
        betaSet.add(12.00);
        betaSet.add(12.11);
        betaSet.add(12.25);

        Set<Double> controlSet = new LinkedHashSet<>();
        controlSet.add(12.11);

        //what test-cases should be here ??
        // perhaps one for custom objects like default one

        // one for wrapper classes of the same type

        // one for two wrapper classes of same value ( say Byte and Double)

        Intersect test1 = new Intersect();

        assertEquals("something wrong with Doubles sets intersection", controlSet, test1.intersect(alphaSet,betaSet));


    }

    @org.junit.Test
    public void intersectWrapperObjectsDifTypesSameValues() {

        Set<Short> alphaSet = new LinkedHashSet<>();
        alphaSet.add((short)1);
        alphaSet.add((short)11);
        alphaSet.add((short)10);

        Set<Byte> betaSet = new LinkedHashSet<>();
        betaSet.add((byte)1);
        betaSet.add((byte)11);
        betaSet.add((byte)10);

        Set<Object> controlSet = new LinkedHashSet<>();
        controlSet.add(1);
        controlSet.add(11);
        controlSet.add(10);

        //what test-cases should be here ??
        // perhaps one for custom objects like default one

        // one for wrapper classes of the same type

        // one for two wrapper classes of same value ( say Byte and Double)

        Intersect test1 = new Intersect();

        assertNotEquals("something wrong with basic sets intersection", controlSet, test1.intersect(alphaSet,betaSet));


    }

    //CustomObject tests
    @org.junit.Test
    public void compareCustomsObjectsSameHashSameFields() {

        CustomObject john = new CustomObject("John",007,18,80,12.12);

        CustomObject jill = new CustomObject("John",007,18,80,12.12);

        Intersect test1 = new Intersect();

        assertTrue("something wrong with hardcoded hashcodes", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsUpperLowerCaseNames() {

        CustomObject john = new CustomObject("JOHN",777,18,80,12.12);

        CustomObject jill = new CustomObject("John",777,18,80,12.12);

        Intersect test1 = new Intersect();

        assertFalse("Upper/lower case names are considered same", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsDashedNames() {

        CustomObject john = new CustomObject("John Paul Van Damm",777,18,80,12.12);

        CustomObject jill = new CustomObject("John-Paul Van Damm",777,18,80,12.12);

        Intersect test1 = new Intersect();

        assertFalse("Dashed name and one without dash are considered same", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsApostropheNames() {

        CustomObject john = new CustomObject("Sinead O'Connor",777,18,80,12.12);

        CustomObject jill = new CustomObject("Sinead OConnor",777,18,80,12.12);

        Intersect test1 = new Intersect();

        assertFalse("Apostrophed name and one without  are considered same", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsOneGrammDifference() {

        CustomObject john = new CustomObject("Sinead O'Connor",777,18,80,12.12);

        CustomObject jill = new CustomObject("Sinead O'Connor",777,18,80.001f,12.12);

        Intersect test1 = new Intersect();

        assertFalse("People with 1 gramm difference are considered equal", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsNanoCentDifference() {

        CustomObject john = new CustomObject("John Claude Van Damm",777,18,80,12.12345678);

        CustomObject jill = new CustomObject("John Claude Van Damm",777,18,80,12.123456789);

        Intersect test1 = new Intersect();

        assertFalse("Objects with nanocent difference are considered same", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsAgeDifference() {

        CustomObject john = new CustomObject("John Claude Van Damm",777,19,80,12.12345678);

        CustomObject jill = new CustomObject("John Claude Van Damm",777,18,80,12.123456789);

        Intersect test1 = new Intersect();

        assertFalse("Objects with age difference are considered same", test1.compareObjects(john, jill));
    }

    @org.junit.Test
    public void compareCustomsObjectsAllDifference() {

        CustomObject john = new CustomObject("John Claude Van Damm",2,55,120,1212345678);

        CustomObject jill = new CustomObject("Arnold Schwarzenegger",4,63,140,999999999);

        Intersect test1 = new Intersect();

        assertFalse("Objects with age difference are considered same", test1.compareObjects(john, jill));
    }


    // Generics tests
    @org.junit.Test
    public void compareObjectsWrappersSameValueDifType() {

        Object object1 = new Double (23);
        Object object2 = new Integer (23);

        Intersect test1 = new Intersect();

        System.out.println("Hashcodes are the following : ");
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        assertFalse("something wrong with wrapper classes of same value but different types", test1.compareObjects(object1, object2));

    }

    @org.junit.Test
    public void compareObjectsWrappersSameValueSameType() {

        Object object1 = new Double (23);
        Object object2 = new Double (23);

        Intersect test1 = new Intersect();
        System.out.println("Hashcodes are the following : ");
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        assertTrue("something wrong with wrapper classes of same value and same types", test1.compareObjects(object1, object2));

    }

    @org.junit.Test
    public void compareObjectsWrappersDifValueSameType() {

        Object object1 = new Double (23);
        Object object2 = new Double (22);

        Intersect test1 = new Intersect();

        System.out.println("Hashcodes are the following : ");
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        assertFalse("something wrong with wrapper classes of different  value but same types", test1.compareObjects(object1, object2));

    }

    @org.junit.Test
    public void compareObjectsAbstractBlank() {

        Object object1 = new Object();
        Object object2 = new Object ();

        Intersect test1 = new Intersect();

        System.out.println("Hashcodes are the following : ");
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        assertFalse("something wrong with wrapper classes of same value but different types", test1.compareObjects(object1, object2));

    }



}