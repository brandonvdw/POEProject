/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
public class POELogin {

    private static boolean bPass = false;
    private static boolean bUser = false;

    public static boolean checkUserName(String username) { // Explain this code
         int underscoreCount = 0;
        if (username.length() > 5) {
            return false;  // Length exceeds 5 characters
        }
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '_') {
                underscoreCount++;        //Increments underscore if there is one
            }
        }
        return underscoreCount == 1; // If underscore account is 1 then checkUserName will return true else it will return false

    }

    public static boolean checkPasswordComplexity(String Password) { // This does not work anynmore, fix it 

        int iCap = 0;
        int iLow = 0;

        if (Password.length() >= 8) {

            for (int k = 0; k < Password.length(); k++) { // Make sure to reference https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase

                if (Password.matches(".*[A-Z].*")) {
                    iCap = iCap + 1;
                    bPass = true;
                    return true;

                } else {
                    bPass = false;
                    return false;

                }
            }
            return true;
        }
        return false;

    }

    public static String registerUser(String UserName, String Password) { // Idk what registerUser is meant to do 

        if (checkPasswordComplexity(Password) == false) {
            return ("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character ");
        } else if (checkUserName(UserName) == false) {
            return ("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        } else {
            return ("Registration successfully captured");
        }
    }

}
