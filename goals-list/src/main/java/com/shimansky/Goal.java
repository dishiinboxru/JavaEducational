package com.shimansky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dev on 28/08/15.
 */

/**
 * This Class is designed to describe a goal parameters and do some basic operations with it.
 */
public class Goal {

    /**

     * @param name - name of goal, it shouldn’t contain numbers and special characters like: “!@#$%^&*(){}”|?><:;’”
     * and be less than 6 characters and more than 20
     * @param description - desription of a goal , it shouldn’t be less than 10 characters and more than 50
     * @param id - identificator of goal
     * @param reached - condition of the Goal, whether it's reached or not.
     */
    private String name;
    private String description;
    private int id;
    private boolean reached;


    /**
     * basic constructor for creating a Goal in the application
     * @param name - name of goal, it shouldn’t contain numbers and special characters like: “!@#$%^&*(){}”|?><:;’”
     * and be less than 6 characters and more than 20
     * @param description - desription of a goal , it shouldn’t be less than 10 characters and more than 50
     * @param id - identificator of goal
     * @param reached - condition of the Goal, whether it's reached or not.
     */
    public Goal(String name, String description, int id, boolean reached) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.reached = reached;
    }

    /**
     * basic getters of goals parameters
     * @return desired parameter
     */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public boolean isReached() {
        return reached;
    }


    /**
     * specialised constructor for working within application interface
     * @param name - name of goal, it shouldn’t contain numbers and special characters like: “!@#$%^&*(){}”|?><:;’”
     *      * and be less than 6 characters and more than 20
     *      * @param description - desription of a goal , it shouldn’t be less than 10 characters and more than 50
     *      * @param id - identificator of goal
     *      * @param reached - condition of the Goal, whether it's reached or not.
     * @return modified Goal
     */
    public static Goal createGoal(String name, String description , int id , boolean reached) {
        return new Goal(name, description, id , reached);
    }

    /**
     * setter for updating goal status
     * @param reached - condition of the Goal, whether it's reached or not.
     */
    public void setReached(boolean reached) {
        this.reached = reached;
    }


}
