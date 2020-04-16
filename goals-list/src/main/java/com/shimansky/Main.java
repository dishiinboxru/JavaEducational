package com.shimansky;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

        3. Goals list
        A list of the goals(tasks) for a user.


-Goal should have next attributes:
id, Name, Description, Reached/NotReached
-User should have next attributes:
First Name, Last Name, NickName, PhoneNumber

The application should allow to:
- edit user’s phoneNumber;
 - edit the user’s NickName;
 - add the goal;
 - edit the goal;
 - set reached/NotReached;

It shall be impossible to:
 - edit First Name, Last Name of the user;
   - remove a goal;

 - Goal validation rules:
 Name:
 - it shouldn’t contain numbers and special characters like: “!@#$%^&*(){}”|?><:;’”
  - it shouldn’t be less than 6 characters and more than 20
 Description:
  - it shouldn’t be less than 10 characters and more than 50


 TODO list - current issues which i haven't got time to resolve properply, but aware of
1 - methods for User and Goal List itself should be separated
2 - method specialCharacterValidation may work better with regex tools, but i haven't figured out yet how they work.
3 - boolean reached = false is not set in constructor, but hard-coded in method addNewGoal
4 - code is not fool-proof - no exceptions handling is implemented
5 - Goals IDs are not handling duplicates whatsoever
6- setting reached/Not reached is done with too much of coding, basically duplicating updateGoal method
7 - issue with system message on status update ( shall be "status updated" instead of " replaced with" )
8 - incorrect location of method specialCharacterValidation- should be in Goals, but had access issues
9 - JUnit tests are not working, I don't understand why.
10 - User parameters should be included in parameters file instead of being hard-coded
11 - some validation is hard-coded, which could be done with primitives (however, those occasions are single ones)
12- Junit test on specialCharacterValidation is done in awkward way, had issues with access modifiers.
13 - Junit tests for console input method are not done at all.
As far as I understood, this requires Mocks and I have no experience with them at the moment.

 Credits
 Final task solution is somewhat based on an ArrayListChallenge from Udemy course "Java Masterclass"
 (by Tim Buchalka)

         */

/**
 * main class of the application. Initialises the scanner and default user with hard-coded parameters.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
 //   private static GoalListUser goalListUser2 = new GoalListUser("johny", "depp","sparrow","9117314453" );

    /**
     * main method of the application. Initialises the work of the list by starting the console interface
     * and showing the user available options
     * @param args
     */
    public static void main(String[] args) {

        /*
        to mock the closing of the application
         */
        boolean quit = false;
        startGoallist();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: ( 0 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    printActions();
                    break;


                case 1:
                    goalListUser.printGoalsList();
                    break;

                case 2:
                    addNewGoal();
                    break;
                case 3:
                    updateGoal();
                    break;
                case 4:
                    updateGoalStatus();
                    break;

                case 5:
                    queryGoal();
                    break;

                case 6:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 7 :
                    phoneUpdate();
                    break;
                case 8 :
                    nickUpdate();
                    break;
                case 9 :
                    showUserInfo();
                    break;
            }

        }

    }

    /**
     * method to add a new goal via console input from the user. validation is partly hard-coded(lengths of inputs),
     * partly done by special methods(absence of special characters and digits).
     */
    private static void addNewGoal() {
        System.out.println("Enter new goal id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        // validation needed
        String name;
        do {
            System.out.println("Enter goal name(6-20 characters, no digits or special symbols) : ");

            name = scanner.nextLine();
        } while (name.length() < 6 || name.length() > 20 || specialCharacterValidation(name) );

        String description;
        do {
            System.out.println("Enter goal description (10-50 characters): ");
            description = scanner.nextLine();
        } while (description.length() < 10 || description.length() > 50);
        //bad practice - should include that in constructor with default value of false
        boolean reached = false;

        Goal newGoal = Goal.createGoal(name, description, id, reached);
        if (goalListUser.addNewGoal(newGoal)) {
            System.out.println("New goal " + id + " added: name = " + name + ", description = " + description);
            if (reached)
                System.out.println(" Status - reached ");
            else
                System.out.println("Status - NOT reached");
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }
    /**
     * method to update a new goal via console input from the user. validation is partly hard-coded(lengths of inputs),
     * partly done by special methods(absence of special characters and digits).
     */
    private static void updateGoal() {
        System.out.println("Enter existing goal name: ");
        String name = scanner.nextLine();
        Goal existingGoalRecord = goalListUser.queryGoal(name);
        if(existingGoalRecord == null) {
            System.out.println("Goal not found.");
            return;
        }
        System.out.print("Enter new goal id: ");
        int  newId = scanner.nextInt();
        scanner.nextLine(); //double scanner to avoid it skipping a line
        String newName;
        do {
            System.out.println("Enter goal name(6-20 characters, no digits or special symbols) : ");

            newName = scanner.nextLine();
        } while (newName.length() < 6 || newName.length() > 20 || specialCharacterValidation(newName) );

        String newDescription;
        do {
            System.out.println("Enter goal description (10-50 characters): ");
            newDescription = scanner.nextLine();
        } while (newDescription.length() < 10 || newDescription.length() > 50);

        boolean reached = false ;
        Goal newGoal = Goal.createGoal(newName, newDescription, newId, reached);
        if(goalListUser.updateGoal(existingGoalRecord, newGoal)) {
            System.out.println("Successfully updated goal");
        } else {
            System.out.println("Error updating goal.");
        }
    }

    /**
     * method based on updateGoal, but just gets the old values and proceeds with changing the boolean.
     * currently it's far from best practice, improvement required.
     */

    private static void updateGoalStatus() {
        System.out.println("Enter existing goal name: ");
        String name = scanner.nextLine();
        Goal existingGoalRecord = goalListUser.queryGoal(name);
        if(existingGoalRecord == null) {
            System.out.println("Goal not found.");
            return;
        }
        System.out.print("Enter new goal status: 1 - for reached, 2 - for NOT reached ");
        int newStatus = scanner.nextInt();
        scanner.nextLine(); //double scanner to avoid it skipping a line
        boolean reached = false;
        if (newStatus == 1)
             reached = true;
        if (newStatus == 2)
             reached = false;

        String oldName = existingGoalRecord.getName();
        String oldDescription = existingGoalRecord.getDescription();
        int oldId = existingGoalRecord.getId();
        Goal newGoal = Goal.createGoal(oldName, oldDescription, oldId, reached);
        if(goalListUser.updateGoal(existingGoalRecord, newGoal)) {
            System.out.println("Successfully updated goal");
        } else {
            System.out.println("Error updating goal.");
        }
    }


    /**
     * method checking if given goal exists by pro,pting user for a goal name via console
     */
    private static void queryGoal() {
        System.out.println("Enter existing goal name: ");
        String name = scanner.nextLine();
        Goal existingGoalRecord = goalListUser.queryGoal(name);
        if (existingGoalRecord == null) {
            System.out.println("Goal not found.");
            return;
        }

        System.out.println("Name: " + existingGoalRecord.getName() + " exists. Description : " + existingGoalRecord.getDescription());
        if(existingGoalRecord.isReached())
        System.out.println(" Status - reached ");
        else
            System.out.println("Status - NOT reached");
    }

    /**
     * method to update user's phone number by prompting the user the new one.
     */
    private static void phoneUpdate() {
        System.out.println("Enter new phone number name: ");
        String newPhoneNumber = scanner.nextLine();

        goalListUser.setMyPhoneNumber(newPhoneNumber);

    }
    /**
     * method to update user's nickname by prompting the user the new one.
     */
    private static void nickUpdate() {
        System.out.println("Enter new nick name: ");
        String newNickName = scanner.nextLine();

        goalListUser.setNickName(newNickName);

    }

    /**
     * method designed to validate whether input has invalid special characters or digits.
     *
     * regex implementation will work faster here.
     * @param name - input from User
     * @return - result of validation . True - it contains them, False - it doesn't.
     */

    public static boolean specialCharacterValidation(String name) {

        String specialCharacters=" !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
        String str2[]=name.split("");
        int count=0;
        for (int i=0;i<str2.length;i++)
        {
            if (specialCharacters.contains(str2[i]))
            {
                count++;
            }
        }

        if (name!=null && count==0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * method which shows all user's information
     */
    private static void showUserInfo() {
        System.out.println("User info :\n " +
                            "first name -" + goalListUser.getFirstName() + "\n" +
                            "last name -" + goalListUser.getLastName() + "\n" +
                            "nick name -" + goalListUser.getNickName() + "\n" +
                            "phone number -" + goalListUser.getMyPhoneNumber() + "\n");


    }

    /**
     * mock method which might be replaced with some real preliminary actions done by the application
     * ( like connecting to DataBase or retrieving data from local file)
     */
    private static void startGoallist() {
        System.out.println("Starting Goal list...");
    }

    /**
     * method for console-based interaction with the user.
     * shows the list of available actions
     */
    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println( "1  - to print goals\n" +
                            "2  - to add a new goal\n" +
                            "3  - to update an existing goal\n" +
                            "4  - to change goal status\n" +
                            "5  - query if a goal exists\n" +
                            "6  - to shut down the programme \n" +
                            "7  - update user's phone number \n" +
                            "8  - update user's nick name \n" +
                            "9  - to print user info \n" );
        System.out.println("Choose your action: ");
    }



























}
