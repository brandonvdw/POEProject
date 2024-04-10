/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
import java.util.Scanner;

public class POEProject {

    public static void main(String[] args) {
        
        
        

        Scanner scanner = new Scanner(System.in);

        String sFirstName = "";
        String sLastName = "";
        String sUsername = "";
        String sPassword = "";

        String sLoginUser = "";
        String sLoginPass = "";

        System.out.println("Please select an option:");
        System.out.println("1. Create an account");
        System.out.println("2. Login");

        int iChoice = scanner.nextInt();

        if (iChoice == 1) {
            

            System.out.println("Please enter your First Name: ");
            sFirstName = scanner.nextLine();
            System.out.println("Please enter your Last Name: ");
            sLastName = scanner.nextLine();
            System.out.println("Please enter a Username:");
            sUsername = scanner.nextLine();
            System.out.println("Please enter a Password: ");
            sPassword = scanner.nextLine();

            System.out.println(POELogin.registerUser(sUsername, sPassword));
            //POELogin user = new POELogin(sUsername, sPassword);

        } else if (iChoice == 2) {
            System.out.println("Please enter your Username");
            sLoginUser = scanner.nextLine();
            System.out.println("Please enter your Password");
            sLoginPass = scanner.nextLine();

        } else {
            System.out.println("Please select a VALID option");
        }

    }
}
