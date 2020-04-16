package com.shimanskii;


import java.util.LinkedList;

public class LinkedListsOperations {

    LinkedList<String> linkedListForTests = new LinkedList<String>(FilesAndCollectionsGenerator.generateLinkedList());

    public LinkedListsOperations() {

    }




    public  void operation (String iterationType, int iterationSize, String iterationLocation) {


//removal block
        if (iterationType.equals("remove")){

            for (int i = 0; i < iterationSize; i++) {
                linkedListForTests.remove(linkedListForTests.size()/2);
            }

        }
//insertions block
        else if (iterationType.equals("add")){

            if (iterationLocation.equals("beginning")){

                for (int i = 0; i < iterationSize; i++) {
                    linkedListForTests.add(0,"0");
                }
            }

            if (iterationLocation.equals("middle")){

                for (int i = 0; i < iterationSize; i++) {
                    linkedListForTests.add((linkedListForTests.size()/2),"0");
                }
            }

            if (iterationLocation.equals("end")){

                for (int i = 0; i < iterationSize; i++) {
                    linkedListForTests.add(linkedListForTests.size(),"0");
                }
            }
        }
        //reading from random location. 1 type of location only
        else if (iterationType.equals("read")){
            int random = (int) Math.random();

            for (int i = 0; i < iterationSize; i++) {
                linkedListForTests.get(random);
            }
        }
    }
}
