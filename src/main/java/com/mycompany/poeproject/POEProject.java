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

        // Creating an instance of Scanner to take user input
        Scanner scanner = new Scanner(System.in);

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

                
                while (User.returnLoginMessage(User, sPassword, sLoginPassMain)) {
                    Integer userSelection = Integer.parseInt(JOptionPane.showInputDialog(f, "Welcome to EasyKanban \nPlease select what you would like to do: \n"
                            + "1. Add tasks \n2.Show report \n3.Quit"));

                    if (userSelection == 1) {

                        Integer tasks = Integer.parseInt(JOptionPane.showInputDialog(f, "How many tasks would you like to add?"));

                        Tasks.setNumberOfTasks(tasks);

                        for (int i = 0; i < tasks; i++) {

                            Tasks.setTaskName(JOptionPane.showInputDialog(f, "Please enter the name of the task: " + i));
                            Tasks.setTaskDescription(JOptionPane.showInputDialog(f, "Enter the task description"));

                            if (!Tasks.checkDescription()) {
                                JOptionPane.showInputDialog(f, "Please enter a task description that is less than 50 characters");
                            } else {
                                
                                Tasks.returnTotalHours();

                                Tasks.setDevName(JOptionPane.showInputDialog(f, "Please enter the full name of the developer"));
                                

                                Tasks.setTaskDuration(Double.parseDouble(JOptionPane.showInputDialog(f, "Please enter the duration of the task in hours")));

                                Tasks.setTaskStat(JOptionPane.showInputDialog(f, "Select the status of the task: \n"
                                        + "1. To Do \n2. Done \n3. Doing"));

                                JOptionPane.showMessageDialog(f, Tasks.printTaskDetails());
                            }
                                

                        }
                        JOptionPane.showMessageDialog(f,"The total amount of hours of all tasks: " + Tasks.returnTotalHours());
                        
                        

                    } else if (userSelection == 2) {

                        JOptionPane.showMessageDialog(f, "Coming soon", "Alert", JOptionPane.WARNING_MESSAGE);

                    } else if (userSelection == 3) {

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
