package com.shimanskii;

import java.util.HashSet;
import java.util.Set;

public class Intersect <T> {

//    Set <CustomObject> intersect;
//
//    public Intersect() {
//
//    }

    public Set < T > intersect (Set <T> alphaSet, Set<T> betaSet){
        Set <T> intersect = new HashSet<T>() ;

        for (T itemAlpha : alphaSet) {
            for (T itemBeta : betaSet ){
                if (compareObjects(itemAlpha, itemBeta)) {
                    intersect.add(itemAlpha);
                }
            }
        }
        return intersect;
    }

    public <T> boolean compareObjects ( T e, T o){

        //shall I somehow check here that both are instances of the same parent class ?

        if (e.hashCode() == o.hashCode() ) {
            if (e.equals(o)) {
                return true;
            }
            else return false;
        }
        else return false;
    }

}
