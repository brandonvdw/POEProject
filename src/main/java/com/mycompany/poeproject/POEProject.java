/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
import javax.swing.JOptionPane;

public class POEProject {

    public static void main(String[] args) {

        String Password = "";
        String Username = "";
        String FirstName = "";
        String LastName = "";

        FirstName = JOptionPane.showInputDialog("Enter your First Name: ");
        LastName = JOptionPane.showInputDialog("Enter your Last Name: ");

        Username = JOptionPane.showInputDialog("Pleases enter your username");
        // JOptionPane.showMessageDialog(null, POELogin.checkUserName(Username));

        Password = JOptionPane.showInputDialog("Pleases enter your password");
        // JOptionPane.showMessageDialog(null, POELogin.checkPasswordComplexity(Password));

        JOptionPane.showMessageDialog(null, POELogin.registerUser(Username, Password));

    }
}
