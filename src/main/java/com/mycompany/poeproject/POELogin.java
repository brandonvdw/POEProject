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

    public static boolean checkPasswordComplexity(String Password) {

        char ch; // To store each character of the password
        boolean bCapital = false; //Boolean flag to see if the current character of the password contains a capital letter 
        boolean bNumber = false; //Boolean flag to see if the current character of the password is a number or not 
        boolean bPass = false; //Boolean flag to see if the current character of the password is a special character or not
        String specialCharacters = "!@#$%^&*()_+{}\":?><,./;'[]\\-="; //String of the special characters that are used to see if the password contaiains any speical characters

        for (int i = 0; i < Password.length(); i++) { // Beginning that goes through each character of the password and checks if the criteria is matched
            ch = Password.charAt(i); // Setting the current character of the password to the char "ch" so that it can be checked 

            // Check if the current character is a special character
            if (specialCharacters.indexOf(ch) != -1) { //Compares ch to the special characters string to see if the current character is a special character or not 
                bPass = true; // Set bPass to true if a special character is found
            } else {
                bPass = false; // Set bPass to false if a special character is found
            }

            // Check if the current character is a digit
            if (Character.isDigit(ch)) {
                bNumber = true; // Set bNumber to true if a digit is found

                // Check if the current character is uppercase
            } else if (Character.isUpperCase(ch)) {
                bCapital = true; // Set bCapital to true if an uppercase letter is found

            }
            if (bNumber && bCapital && bPass) { //Checks to see if all criteria is met, if so then true will be returned
                return true;
            }
        }
        return false; // If the loop completes without meeting all criteria the it will return false

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

    public static boolean loginUser(String sLoginUser, String LoginPass) {

        return false;

    }

}
