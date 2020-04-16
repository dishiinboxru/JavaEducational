package com.shimansky;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoalListUserTest {

    @Test
    public void setNickName() {

        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = goalListUser.getNickName();
        goalListUser.setNickName("Cryboy");
        String str2 = goalListUser.getNickName();
        assertNotEquals( "error message" , str1, str2 );
    }

    @Test
    public void setMyPhoneNumber() {

        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = goalListUser.getMyPhoneNumber();
        goalListUser.setMyPhoneNumber("999666111");
        String str2 = goalListUser.getMyPhoneNumber();
        assertNotEquals( "error message" , str1, str2 );
    }

    @Test

    public void getFirstName() {

        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = "johny";
        String str2 = goalListUser.getFirstName();
        assertEquals( "error message" , str1, str2 );

    }

    @Test
    public void getLastName() {

        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = "depp";
        String str2 = goalListUser.getLastName();
        assertEquals( "error message" , str1, str2 );
    }

    @Test
    public void getNickName() {
        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = "sparrow";
        String str2 = goalListUser.getNickName();
        assertEquals( "error message" , str1, str2 );
    }

    @Test
    public void getMyPhoneNumber() {
        GoalListUser goalListUser = new GoalListUser("johny", "depp","sparrow","9117314453" );
        String str1 = "9117314453";
        String str2 = goalListUser.getMyPhoneNumber();
        assertEquals( "error message" , str1, str2 );
    }

    //? how to test this ?
    @Test
    public void printGoalsList() {
    }
}