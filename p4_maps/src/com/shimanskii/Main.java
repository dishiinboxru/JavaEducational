package com.shimanskii;

import java.util.*;
import java.util.stream.Collectors;

import static com.shimanskii.SourcesGenerator.populateMap;
import static javafx.scene.input.KeyCode.V;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //file has been already generated - switched off for debugging purposes
        SourcesGenerator.generateTwoFilesForTwoMaps();

        LinkedHashMap<String, Long > alphaMap = new LinkedHashMap<>();
        LinkedHashMap <String, Long > bettaMap = new LinkedHashMap<>();

        SourcesGenerator.populateTwoMaps(alphaMap,bettaMap);
        System.out.println("initial alphamap size is " + alphaMap.size());
        System.out.println("initial beta maps size is " + bettaMap.size());

     //   block for finding keys duplicates and then retrieving their values
        Set<String> alphaKeys = new LinkedHashSet <String> (alphaMap.keySet());
        Set<String> betaKeys = new LinkedHashSet <String> (bettaMap.keySet());

        //list for collecting all the data to include in the report. all current system messages are now duplicated with entries into that list.
        LinkedList <String> messages = new LinkedList<>();

  //block for reversing maps
        Map<Long, String> alphaMapReversed = new HashMap<>();
        for(Map.Entry<String, Long> entry : alphaMap.entrySet()){
            alphaMapReversed.put(entry.getValue(), entry.getKey());
        }

        Map<Long, String> betaMapReversed = new HashMap<>();
        for(Map.Entry<String, Long> entry : bettaMap.entrySet()){
            betaMapReversed.put(entry.getValue(), entry.getKey());
        }
        System.out.println("reversed alphamap size is " + alphaMapReversed.size());
        System.out.println("reversed beta maps size is " + betaMapReversed.size());

        //doing part c of the task ( duplicated keys and values correspondent to them)
        String entryMessage = "Here comes alpha map keys";
        System.out.println(entryMessage);
      //  messages.add(entryMessage);
        System.out.println(alphaKeys);
       // messages.add(alphaKeys.toString());

        String sysMessageforKeys = "Here comes keys presented in both maps keys";
        System.out.println(sysMessageforKeys);
        messages.add(sysMessageforKeys);

        alphaKeys.retainAll(bettaMap.keySet());
        System.out.println("Keys intersection size is " + alphaKeys.size());
        messages.add("Keys intersection size is " + alphaKeys.size());
        System.out.println(alphaKeys);
        messages.add(alphaKeys.toString());


       // results output block for part c
            System.out.println("And now the values for those keys");
        for (String key : alphaKeys) {
            System.out.println("key " + key + " in alpha Map returns value of " + alphaMap.get(key));
            System.out.println("key " + key + " in betta Map returns value of " +bettaMap.get(key));
            messages.add("key " + key + " in alpha Map returns value of " + alphaMap.get(key));
            messages.add("key " + key + " in betta Map returns value of " +bettaMap.get(key));
        }

        //block for checking values duplicates and getting their keys ( same idea , but now applied to reversed maps) - part d
        Set<Long> alphaValues = new LinkedHashSet <Long> (alphaMapReversed.keySet());
        Set<Long> betaValues = new LinkedHashSet <Long> (betaMapReversed.keySet());

        System.out.println("here comes alpha map values");
      //  messages.add("here comes alpha map values");
        System.out.println(alphaValues);
     //   messages.add(alphaValues.toString());
        System.out.println("Here comes values, presented in both maps");
        messages.add("Here comes values, presented in both maps");

        alphaValues.retainAll(betaValues);

        System.out.println("Values intersection size is " + alphaValues.size());
        messages.add("Values intersection size is " + alphaValues.size());
        System.out.println(alphaValues);
        messages.add(alphaValues.toString());

        System.out.println("And now keys for those values");
        for (Long value : alphaValues){
            System.out.println("value " + value + " in alpha Map returns key of " + alphaMapReversed.get(value));
            System.out.println("value " + value + " in beta Map returns key of " + betaMapReversed.get(value));
            messages.add("value " + value + " in alpha Map returns key of " + alphaMapReversed.get(value));
            messages.add("value " + value + " in beta Map returns key of " + betaMapReversed.get(value));
        }

        Reporter.appendingOutput(messages);

        //supposed to work, but I can't understand how, thus leave for later
//        public static <K, V> K getKey(Map<K, V> map, V value) {
//            for (Map.Entry<K, V> entry : map.entrySet()) {
//                if (value.equals(entry.getValue())) {
//                    return entry.getKey();
//                }
//            }
//            return null;
//        }


//lambda expression for reversing , can't understand as well
//        Map<Integer, String> mapInversed =
//                alphaMap.entrySet()
//                        .stream()
//                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    }
}
