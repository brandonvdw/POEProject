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

        POELogin User = new POELogin();

        Scanner scanner = new Scanner(System.in);

        boolean bPass;

        String sFirstName = "";
        String sLastName = "";
        String sUsername = "";
        String sPassword = "";

        String sLoginUserMain = "";
        String sLoginPassMain = "";

        while (bPass = true) {

            System.out.println("Please select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Login");
            System.out.println("3. Quit");

            int iChoice = scanner.nextInt();
            scanner.nextLine();
            if (iChoice == 1) {

                System.out.println("Please enter your First Name: ");
                sFirstName = scanner.nextLine();
                User.setsLoginName(sFirstName);

                System.out.println("Please enter your Last Name: ");
                sLastName = scanner.nextLine();
                User.setsLoginLastName(sLastName);

                System.out.println("Please enter a Username:");
                sUsername = scanner.nextLine();
                User.setsRegisterUser(sUsername);

                System.out.println("Please enter a Password: ");
                sPassword = scanner.nextLine();
                User.setsRegisterPass(sPassword);

                System.out.println(POELogin.registerUser(sUsername, sPassword));
                //POELogin user = new POELogin(sUsername, sPassword);

                if (POELogin.checkUserName(sUsername) == true && POELogin.checkPasswordComplexity(sPassword) == true) {
                    bPass = false;
                } else {
                    bPass = true;
                }

            } else if (iChoice == 2) {
                System.out.println("Please enter your Username");
                sLoginUserMain = scanner.nextLine();
                User.setsLoginUser(sLoginUserMain);

                System.out.println("Please enter your Password");
                sLoginPassMain = scanner.nextLine();
                User.setsLoginPass(sLoginPassMain);

                System.out.println(POELogin.returnLoginStatus(User));

        
            } else if (iChoice == 3){
               break;
            }else  
            System.out.println("Please select a VALID option");

        }
    }
}
