package com.shimansky;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 28/08/15.
 */

/**
 * A class designed to work with parameters of the user and his actions with the goal list.
 */
public class GoalListUser {

    /**
     * parameters of the User, including first, last and nick name, phone number.
     * List myGoals is doing functional part of keeping goals in sorted order.
     */
    private String firstName;
    private String lastName;
    private String nickName;
    private String myPhoneNumber;
    private List<Goal> myGoals;

    /**
     * basic constructor for creating a user.
     * @param firstName
     * @param lastName
     * @param nickName
     * @param myPhoneNumber
     */
    public GoalListUser(String firstName, String lastName, String nickName, String myPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.myPhoneNumber = myPhoneNumber;
        this.myGoals = new ArrayList<Goal>();
    }

    /**
     * setters for User.
     * setters are limited to Nickname and phonenumber according to specification stating that first and last name shall not be modified.
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setMyPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    /**
     * Getters for users parameters.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMyPhoneNumber() {
        return myPhoneNumber;
    }


    /**
     * method to add new goals to the goal list
     * @param goal - input parameter to check if goals is already on the list
     * @return - new created goal
     */
    public boolean addNewGoal(Goal goal) {
        if(findGoal(goal.getName()) >=0) {
            System.out.println("Goal is already on file");
            return false;
        }

        myGoals.add(goal);
        return true;

    }

    /**
     * method to update existing goals details
     * @param oldGoal - the existing goals
     * @param newGoal - the goal with modified parameters
     * @return
     */
    public boolean updateGoal(Goal oldGoal, Goal newGoal) {
        int foundPosition = findGoal(oldGoal);
        if(foundPosition <0) {
            System.out.println(oldGoal.getName() +", was not found.");
            return false;
        }

        this.myGoals.set(foundPosition, newGoal);
        System.out.println(oldGoal.getName() + ", was updated with " + newGoal.getName());
        return true;
    }


    /**
     * method to find goals' indexes in order to do more complex manipulations with them.
     * @param goal -  the goal which is supposed to be found
     * @return
     */
    private int findGoal(Goal goal) {
        return this.myGoals.indexOf(goal);
    }

    /**
     * method to find goal's index based on its name
     * @param name - name of the goal you need to find
     * @return
     */
    private int findGoal(String name) {
        for(int i = 0; i < this.myGoals.size(); i++) {
            Goal goal = this.myGoals.get(i);
            if(goal.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * method to check whether goal exists
     * @param goal - goal to be checked
     * @return
     */
    public String queryGoal(Goal goal) {
        if(findGoal(goal) >=0) {
            return goal.getName();
        }
        return null;
    }

    /**
     * method to check whether goal exists based on its name
     * @param name - goal of the goal to be checked
     * @return
     */
    public Goal queryGoal(String name) {
        int position = findGoal(name);
        if(position >=0) {
            return this.myGoals.get(position);
        }

        return null;
    }

    /**
     * method to print the list of existing goals
     */
    public void printGoalsList() {
        System.out.println("Goal List");
        for(int i = 0; i<this.myGoals.size(); i++) {
            System.out.println((this.myGoals.get(i).getId()) + "." +
                        this.myGoals.get(i).getName() + " -> " +
                        this.myGoals.get(i).getDescription()+ " -> status : ");

                       if( this.myGoals.get(i).isReached() )
                           System.out.println("Reached");
                        else
                           System.out.println("Not reached");
        }

    }





















}
