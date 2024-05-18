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
    private String sLoginPass; // Login Password
    private String sLoginUser; // Login Usernme
    private String sLoginName; // Login First name
    private String sLoginLastName; //Login Last Name
    private String sRegisterPass; // Register User Password
    private String sRegisterUser; // Register User Name

    //Reference 
    // According to baeldung(2024) the .charAt() method returns the character at a given position in a string
    // I used the .charAt(0) method to get the current character of the string and compare it to a string to see if the username had a underscore
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

    /* In-text References:
    
     1.)According to ashmitraj(2020) .isDigit(ch) is a method in Java that can dertermine whether a single charcter is a number or not
     I used the .isDigit method to check if the password contained a number in it
    
     2.)According to Kai Yuan(2024) .isUppercase is a method in Java that can determine whether a single character is a capital letter or not
     I used the .isDigit method to check if the password contained a capital ltter in it
    
     3.)According to GeeksforGeeks(2023) .indexOf() method returns the position of the first occurrence of the specified character given to it
     I used the .indexOf() method to see if the password contained any special characters in it
    
     4.)According to baeldung(2024) the .charAt() method returns the character at a given position in a string
     I used the .charAt(0) method to get the current character of the string and compare it to avarious strings to see if the password meets the requirements
    
    */
    
    // Follwing method enssures that the password entered meets all the requirements
    public static boolean checkPasswordComplexity(String Password) { //Checks if the password has all the requirements

        char ch;
        boolean bCapital = false; // To check if there is a capital letter
        boolean bNumber = false; // To check if there is a number

        //String of the special characters that are used to see if the password contaiains any speical characters
        String specialCharacters = "!@#$%^&*()_+{}\":?><,./;'[]\\-="; //Reference this 

        for (int i = 0; i < Password.length(); i++) { // Beginning that goes through each character of the password and checks if the criteria is matched
            ch = Password.charAt(i); // Setting the current character of the password to the char "ch" so that it can be checked 

            // Check if the current character is a special character
            if (specialCharacters.indexOf(ch) != -1) { //Checks to see if the current character is a special character or not

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
        if (returnLoginMessage(User, sRPass, sLPass)) {
            return ("Welcome " + sLName + ", " + User.getsLoginLastName() + " it is great to see you again");
        } else {
            return ("Username or password incorrect, please try again");
        }
    }

    // Displays a message for the user so that the user knows they entered their username in the correct format
    public static String UserRegisterMessage(String CheckUsername) {

        if (POELogin.checkUserName(CheckUsername)) {
            return "Username succesfully captured";
        } else {
            return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than 5 characters in length";
        }

    }

    // Displays a message for the user so that the user knows they entered their password in the correct format
    public static String UserRegisterMessagePassword(String CheckPassword) {

        if (POELogin.checkPasswordComplexity(CheckPassword)) {
            return "Password successfully captured";
        } else {
            return "Password is not correctly formatted please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        }

    }

    // Detects whether the user is logged in or not
    public static boolean returnLoginMessage(POELogin User, String sRPass, String sLPass) {
        if (sLPass.equals(sRPass) && User.getsLoginUser().equals(User.getsRegisterUser())) {
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
 
/* References:

  ashmitraj. 2020. Character isDigit() method in Java with examples.(Version 1.0-SNAPSHOT) [Source code]. https://www.geeksforgeeks.org/character-isdigit-method-in-java-with-examples/. (Accessed 9 April 2024)

  baeldung. 2024. Getting a Character by Index From a String in Java.(Version 1.0-SNAPSHOT) [Source code]. https://www.baeldung.com/java-character-at-position (Accessed 9 April 2024)

  GeeksforGeeks. 2023. In Java, String indexOf() method returns the position of the first occurrence of the specified character or string in a specified string.(Version 1.0-SNAPSHOT) [Source code]. https://www.geeksforgeeks.org/java-string-indexof/ (Accessed 9 April 2024)

  Kai Yuan. 2024. Check if a String Is All Uppercase or Lowercase in Java.(Version 1.0-SNAPSHOT) [Source code]. https://www.baeldung.com/java-check-string-uppercase-lowercase#:~:text=isLowerCase()%20and%20Character.,is%20a%20lower%2Fuppercase%20character.. (Accessed 9 April 2024)

 */
