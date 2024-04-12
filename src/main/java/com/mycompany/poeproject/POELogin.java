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

    //Variables to store all the user's information
    private static String sLoginPass; // Login Password
    private static String sLoginUser; // Login Usernme
    private static String sLoginName; // Login First name
    private static String sLoginLastName; //Login Last Name
    private static String sRegisterPass; // Register User Password
    private static String sRegisterUser; // Register User Name
    private static boolean bLoginConfirm = false; //Boolean to check if the user is logged in

    public static boolean checkUserName(String username) { // This method checks that the username meets the reuirements
        int underscoreCount = 0;
        if (username.length() > 5) { //Checks if the username entered is greater than 5 characters
            return false; // If the username exceeds 5 characters it will return false
        }
        for (int i = 0; i < username.length(); i++) { //Beginning of forloop
            if (username.charAt(i) == '_') { //Checks to see if the current character of the username is a underscore
                underscoreCount++;        //Increments underscore if there is one
            }
        }
        return underscoreCount == 1; // If underscore account is 1 then checkUserName will return true else it will return false

    }
    // Follwing method enssures that the password entered meets all the requirements

    public static boolean checkPasswordComplexity(String Password) {

        char ch;
        boolean bCapital = false; // To check if there is a capital letter
        boolean bNumber = false; // To check if there is a number

        //String of the special characters that are used to see if the password contaiains any speical characters
        String specialCharacters = "!@#$%^&*()_+{}\":?><,./;'[]\\-=";

        for (int i = 0; i < Password.length(); i++) { // Beginning that goes through each character of the password and checks if the criteria is matched
            ch = Password.charAt(i); // Setting the current character of the password to the char "ch" so that it can be checked 

            // Check if the current character is a special character
            if (specialCharacters.indexOf(ch) != -1) { //Checks to see if the current character is a string or not

                //Checks to see if the current character is a digit
            } else if (Character.isDigit(ch)) {
                bNumber = true;

                // Check if the current character is uppercase
            } else if (Character.isUpperCase(ch)) {
                bCapital = true;

            }

        }
        if (bNumber && bCapital) { //Checks to see if all criteria is met, if so then true will be returned
            return true;
        }
        return false; // If the loop completes without meeting all criteria the it will return false

    }

    // Returns the correct message to the user based on other methods results
    public static String registerUser(String UserName, String Password) {

        if (!checkPasswordComplexity(Password)) {
            return ("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character ");
        } else if (!checkUserName(UserName)) {
            return ("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        } else {
            return ("Registration successfully captured");
        }
    }

    // Verifies that the information entered is the same as the matches the information uses when registering 
    public static boolean loginUser(POELogin User, String sLoginUser, String LoginPass) {

        // Comapares the users login to the users register information 
        if (User.getsRegisterUser().equals(User.getsLoginUser()) && User.getsRegisterPass().equals(User.getsLoginPass())) {
            return true; //Returns true if the information listed above matches

        } else {
            return false; //Returns false if the information listed above matches
        }

    }

    //Provides the necessary messaging to the user by comparing the Login and Register information
    public static String returnLoginStatus(POELogin User, String sRPass, String sLPass, String sLName, String sRName) {

        if (returnLoginMessage(User, sRPass, sLPass, sLName, sRName)) {
            return ("Welcome " + User.getsLoginName() + ", " + User.getsLoginLastName() + " it is great to see you again");
        } else {
            return ("Username or password incorrect, please try again");
        }

    }

    public static String UserRegisterMessage(String CheckUsername) {

        if (POELogin.checkUserName(CheckUsername)) {
            return "Username succesfully captured";
        } else {
            return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 characters in length";
        }

    }

    public static String UserRegisterMessagePassword(String CheckPassword) {

        if (POELogin.checkPasswordComplexity(CheckPassword)) {
            return "Password successfully captured";
        } else {
            return "Password is not correctly formatted please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        }

    }

    public static boolean returnLoginMessage(POELogin User, String sRPass, String sLPass, String sLName, String sRName) {

        // Get the appropraite methods and set them to the apporpriate variables so they can be compared
        sLPass = sLoginPass;
        sRPass = sRegisterPass;
        sLName = sLoginUser;
        sRName = sRegisterUser;

        // If the login and register Usernames and Passwords matches then it will return the apporopriate message
        if (sLPass.equals(sRPass) && sLName.equals(sRName)) {
            return true;

        } else {
            return false;
        }

    }

    // Getter for login password
    public String getsLoginPass() {
        return sLoginPass;
    }

    // Getter for login username
    public String getsLoginUser() {
        return sLoginUser;
    }

    // Getter for login name
    public String getsLoginName() {
        return sLoginName;
    }

    // Getter for login last name
    public String getsLoginLastName() {
        return sLoginLastName;
    }

    // Setter for login password
    public void setsLoginPass(String sLoginPass) {
        this.sLoginPass = sLoginPass;
    }

    // Setter for login username
    public void setsLoginUser(String sLoginUser) {
        this.sLoginUser = sLoginUser;
    }

    // Setter for login name
    public void setsLoginName(String sLoginName) {
        this.sLoginName = sLoginName;
    }

    // Setter for login last name
    public void setsLoginLastName(String sLoginLastName) {
        this.sLoginLastName = sLoginLastName;
    }

    // Setter for registration password
    public void setsRegisterPass(String sRegisterPass) {
        this.sRegisterPass = sRegisterPass;
    }

    // Setter for registration username
    public void setsRegisterUser(String sRegisterUser) {
        this.sRegisterUser = sRegisterUser;
    }

    // Getter for registration password
    public String getsRegisterPass() {
        return sRegisterPass;
    }

    // Getter for registration username
    public String getsRegisterUser() {
        return sRegisterUser;
    }

}
