package com.test.util;

/**
 * Created by mrmas on 01.06.2016.
 */
public class PasswordValidator {

    public static int checkPasswordStrength(String password) {

        if(password.length() < 6) {
            return 0;
        }

        int strength=0;
        String[] partialRegexChecks = { ".*[a-z]+.*",
                                        ".*[A-Z]+.*",
                                        ".*[\\d]+.*" };



        if (password.matches(partialRegexChecks[0])) {
            strength += 1;
        }
        if (password.matches(partialRegexChecks[1])) {
            strength += 1;
        }
        if (password.matches(partialRegexChecks[2])) {
            strength += 1;
        }


        return strength;
    }
}
