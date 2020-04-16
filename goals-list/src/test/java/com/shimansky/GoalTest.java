package com.shimansky;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoalTest {
    /**
     * test to check whether it's possible to change goal status with setReached method
     */
    @Test

    public void setReached() {
        Goal goal = new Goal("test goal", "long enough description", 1 , false);
        boolean setreached = true;
        goal.setReached(setreached);
        assertTrue("goal is not set to reached", goal.isReached());
    }

    /**
     * test to check whether method specialCharacterValidation returns false on a name with digits
     */
    @Test
    public void specialCharacterValidation() {
     String name = "123oops";
    boolean check = specialCharacterValidation( name);

    assertFalse( "validation doesn't work",check);
    }

    /**
     * test to check whether method specialCharacterValidation returns false on a name with special characters
     */
    @Test
    public void specialCharacterValidation2() {
        String name = "!@#oops";
        boolean check = specialCharacterValidation( name);

        assertFalse( "validation doesn't work",check);
    }

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
}