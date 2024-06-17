/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poeproject;

/**
 *
 *
 * @author brand
 */
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class POEProject {

    public static void main(String[] args) {

        // Creating an instance of POELogin class
        POELogin User = new POELogin();

        // Creating a instance of the TaskClass class
        TaskClass Tasks = new TaskClass();
        
        DisplayTaskReport Report = new DisplayTaskReport();

        // Creating an instance of Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        //Creating a new JFrame and initialising it
        JFrame f;
        f = new JFrame();
        
       

        boolean bPass; //Flag to control the loop

        //Initialised varibales to store all the user's information
        String sFirstName = ""; //User's First name
        String sLastName = ""; // User's Last name
        String sUsername = ""; // User's Username
        String sPassword = ""; // Users's Passowrd

        String sLoginUserMain = ""; //User's Login Username
        String sLoginPassMain = ""; //User's Login Password
        
        

        //While loop that will continue displaying options to the user unless the user chooses option 3 (which is to quit)
        while (bPass = true) {

            System.out.println("Please select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Login");
            System.out.println("3. Quit");

            //Sets the users input to a integer to see which option they chose
            int iChoice = scanner.nextInt();
            scanner.nextLine();
            if (iChoice == 1) {

                //Creating an account and setting the appropriate fields to the aappropriate setters
                System.out.println("Please enter your First Name: ");
                sFirstName = scanner.nextLine();
                User.setsLoginName(sFirstName);

                System.out.println("Please enter your Last Name: ");
                sLastName = scanner.nextLine();
                User.setsLoginLastName(sLastName);

                System.out.println("Please enter a Username:");
                sUsername = scanner.nextLine();
                User.setsRegisterUser(sUsername);
                System.out.println(User.UserRegisterMessage(sUsername));

                System.out.println("Please enter a Password: ");
                sPassword = scanner.nextLine();
                User.setsRegisterPass(sPassword);
                System.out.println(User.UserRegisterMessagePassword(sPassword));

                // Checking the validity of username and password by calling the "registerUser" method
                System.out.println(POELogin.registerUser(sUsername, sPassword));

                // Checking if username and password meet the criteria by c
                if (POELogin.checkUserName(sUsername) && POELogin.checkPasswordComplexity(sPassword)) {
                    bPass = false; // Setting the flag to false to exit the loop
                } else {
                    bPass = true; // Setting the flag to true to continue the loop
                }
                // If the user chose option 2 then the following login prompts will take place by setting the appropraite fieldsin the login class
            } else if (iChoice == 2) {

                System.out.println("Please enter your Username");
                sLoginUserMain = scanner.nextLine();
                User.setsLoginUser(sLoginUserMain);

                System.out.println("Please enter your Password");
                sLoginPassMain = scanner.nextLine();
                User.setsLoginPass(sLoginPassMain);

                //Method that returns the login status and tells the user if they have entered their inforation correctly or not
                System.out.println(POELogin.returnLoginStatus(User, sPassword, sLoginPassMain, sLoginUserMain, sUsername));
                
                /*
                In text references: 
                
                1.) According to chinmaya121221(2023) the JOptionPane is a part of the Java Swing library. It helps create visual dialog boxes such as message dialogs, conformation dialogs, input dialogs, and options dialog.
                I used the JOptionPane to prompt the user for multiple inputs via a dialog box and also display information to the user via the show message dialog interface
                
                2.) According to Chinmoy (2019)a forloop in Java is used when actions or statements need to be executed repeated over and over again.
                I used the forloop to loop through set code based on how many tasks the user chose to enter so that I dont have to repeat that code 
                
                3.)According to Chinmoy (2019) a while loop is a statement that will repeat lines of code unless a boolean condition is met. 
                I used the while loop to keep prompting the user the 3 options they get only when they have successfully logged in (keep looping while they're logged in)
                
                4.) According to Rajput-Ji (2018) in order to convert a string to a double, the "Double.parseDouble(str)" function must be used to convert the string type to a double data type
                I used the .parseDouble function to convert the hours that the user entered (which are a string) to a double which can be used later for mathematical calculations 
                */

                // The following detects if the user has logged in and then runs a while loop only if the user has logged in
                
                while (User.returnLoginMessage(User, sPassword, sLoginPassMain)) {

                    // Prompts the user with 3 options using a JOptionPane (Note JOptionPane is used from now on)
                    Integer userSelection = Integer.parseInt(JOptionPane.showInputDialog(f, "Welcome to EasyKanban \nPlease select what you would like to do: \n"
                            + "1. Add tasks \n2.Show report \n3.Quit"));

                    if (userSelection == 1) { // If user selects option 1 (Add tasks)

                        // Prompt the user to enter the amount of tasks they want to add
                        Integer tasks = Integer.parseInt(JOptionPane.showInputDialog(f, "How many tasks would you like to add?"));

                        // Set the number of tasks in the Tasks class so that it can be tracked later
                        Tasks.setNumberOfTasks(tasks);

                        // Loop through the number of tasks to gather details for each task
                        
                        
                        for (int i = 0; i < tasks; i++) {

                            // Prompt user to enter the name of the task
                            Tasks.setTaskName(JOptionPane.showInputDialog(f, "Please enter the name of the task: " + i));
                            
                            // Prompt user to enter the description of the task
                            Tasks.setTaskDescription(JOptionPane.showInputDialog(f, "Enter the task description"));

                            // Check if the task description is valid (has to be less than 50 characters)
                            if (!Tasks.checkDescription()) {
                                
                                // If not valid, it will prompt user to enter a valid task description
                                JOptionPane.showInputDialog(f, "Please enter a task description that is less than 50 characters");
                            } else {
                                // If valid, proceed to gather more task details

                                // Called the return total hours method before displaying it at the end again so that memory doesn't reset it
                                Tasks.returnTotalHours();

                                // Prompt and set developer's full name
                                Tasks.setDevName(JOptionPane.showInputDialog(f, "Please enter the full name of the developer"));

                                // Prompt and set duration of the task in hours
                                Tasks.setTaskDuration(Double.parseDouble(JOptionPane.showInputDialog(f, "Please enter the duration of the task in hours")));

                                // Prompt and set the status of the task
                                Tasks.setTaskStat(JOptionPane.showInputDialog(f, "Select the status of the task: \n"
                                        + "1. To Do \n2. Done \n3. Doing"));

                                // Call the method to display the task details using a message dialog
                                JOptionPane.showMessageDialog(f, Tasks.printTaskDetails());
                            }
                            
                           Report.setCurrentPosition(i); // Setting the current position of the loop to populate the arrays in teh DisplayTaskReport Class
                            
                            
                        }
                        // After adding all tasks, display the total amount of hours for all tasks by calling the returnTotalHours method
                        JOptionPane.showMessageDialog(f, "The total amount of hours of all tasks: " + Tasks.returnTotalHours());

                    } else if (userSelection == 2) { // If user selects option 2 (Show report)

                        // Display a "Coming soon" message
                        JOptionPane.showMessageDialog(f, "Coming soon", "Alert", JOptionPane.WARNING_MESSAGE);

                    } else if (userSelection == 3) { // If user selects option 3 (Quit)

                        // Exit the while loop, ending the program
                        break;
                    }
                }

            } else if (iChoice == 3) {
                //Exiting the loop if yhe user chooses option 3 ("Quit")
                break;
            } else {
                // Prompting the user to select a valid option if anything other than the prompted input is typed 
                System.out.println("Please select a VALID option");
            }

        }

    }
    
    

}



/* References:

chinmaya121221. 2023. Java JOptionPane. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/java-joptionpane/ . (Accessed 16 May 2024) 

Chinmoy. 2019. Java For loop with Examples. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/java-for-loop-with-examples/ (Accessed 16 May 2023).

Chinmoy. 2019. Java while loop with Examples. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/java-while-loop-with-examples/ (Accessed 16 May 2023).

Rajput-Ji. 2018. Convert String to Double in Java. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/convert-string-to-double-in-java/ (Accessed 16 May 2023).

*/