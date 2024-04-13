/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package POEJUnitTest;

import com.mycompany.poeproject.POELogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brand
 */
public class POEJUnitTest {

@Test
void testReturnLoginStatus() {
    // Create a new instance of POELogin
    POELogin User = new POELogin();

    // Set the login username directly on the POELogin object
    User.setsLoginUser("kyl_1");

    // Setting the test data for other variables
    String TestRegisterPass = "Brandon@2005";
    String TestLoginPass = "Brandon@2005";
    String TestLoginUser = "kyl_1";
    String TestRegisterUser = "kyl_1";

    // Set other necessary data
    User.setsLoginPass(TestLoginPass);
    User.setsRegisterPass(TestRegisterPass);
    User.setsLoginName(TestLoginUser);
    User.setsLoginLastName("Last Name");
    User.setsRegisterUser(TestRegisterUser);

    // Now call the returnLoginStatus method with appropriate parameters
    String sExpected = ("Welcome " + TestLoginUser + ", Last Name it is great to see you again");
    String sActual = POELogin.returnLoginStatus(User, TestRegisterPass, TestLoginPass, TestLoginUser, TestRegisterUser);

    Assertions.assertEquals(sExpected, sActual);
}



    @Test
    void testCheckRegisterUser() {

        POELogin User = new POELogin();

        String TestUserName = "kyle!!!!!!!";
        String TestPassword = "Ch&&sec@ke99!"; //Correct password given so that it does not affect the result

        String sExpected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";

        String sActual = User.registerUser(TestUserName, TestPassword);

        Assertions.assertEquals(sExpected, sActual);

    }

    @Test
    void testUserRegisterMessagePassword() {

        POELogin User = new POELogin();

        String sExpected = "Password successfully captured";
        String sActual = POELogin.UserRegisterMessagePassword("Ch&&sec@ke99!");

        Assertions.assertEquals(sExpected, sActual);

    }

    @Test
    void testInvalidUserRegisterMessagePassword() {

        POELogin User = new POELogin();

        String sExpected = "Password successfully captured";
        String sActual = POELogin.UserRegisterMessagePassword("password");

        Assertions.assertNotEquals(sExpected, sActual);

    }

    @Test
    void testCheckUserName() {

        POELogin User = new POELogin();

        boolean bExpected = true;
        boolean bActual = POELogin.checkUserName("kyl_1");

        Assertions.assertEquals(bExpected, bActual);

    }

    @Test
    void testCheckInvalidUserName() {

        POELogin User = new POELogin();

        boolean bExpected = true;
        boolean bActual = POELogin.checkUserName("User");

        Assertions.assertNotEquals(bExpected, bActual);

    }

    @Test
    void testCheckPassowrd() {

        POELogin User = new POELogin();

        boolean bExpected = true;
        boolean bActual = POELogin.checkPasswordComplexity("Ch&&sec@ke99!");

        Assertions.assertEquals(bExpected, bActual);

    }

    @Test
    void testCheckInvalidPassword() {

        POELogin User = new POELogin();

        boolean bExpected = true;
        boolean bActual = POELogin.checkPasswordComplexity("password");

        Assertions.assertNotEquals(bExpected, bActual);

    }
    
 
     @Test
    void returnLoginMessage() {

       // Create a new instance of POELogin
    POELogin User = new POELogin();

    // Set the login username directly on the POELogin object
    User.setsLoginUser("kyl_1");

    // Setting the test data for other variables
    String TestRegisterPass = "Brandon@2005";
    String TestLoginPass = "Brandon@2005";
    String TestLoginUser = "kyl_1";
    String TestRegisterUser = "kyl_1";

    // Set other necessary data
    User.setsLoginPass(TestLoginPass);
    User.setsRegisterPass(TestRegisterPass);
    User.setsLoginName(TestLoginUser);
    User.setsLoginLastName("Last Name");
    User.setsRegisterUser(TestRegisterUser);

    // Now call the returnLoginStatus method with appropriate parameters
    boolean bExpected = true;
    boolean bActual = POELogin.returnLoginMessage(User, TestLoginPass, TestLoginPass);

    Assertions.assertEquals(bExpected, bActual);

    }

    
    
       @Test
    void returnInvalidLoginMessage() {

       // Create a new instance of POELogin
    POELogin User = new POELogin();

    // Set the login username directly on the POELogin object
    User.setsLoginUser("kyl_1");

    // Setting the test data for other variables
    String TestRegisterPass = "password";
    String TestLoginPass = "password";
    String TestLoginUser = "kyl!!!!!!!";
    String TestRegisterUser = "kyl!!!!!!!";

    // Set other necessary data
    User.setsLoginPass(TestLoginPass);
    User.setsRegisterPass(TestRegisterPass);
    User.setsLoginName(TestLoginUser);
    User.setsLoginLastName("Last Name");
    User.setsRegisterUser(TestRegisterUser);

    // Now call the returnLoginStatus method with appropriate parameters
    boolean bExpected = true;
    boolean bActual = POELogin.returnLoginMessage(User, TestLoginPass, TestLoginPass);

    Assertions.assertNotEquals(bExpected, bActual);

    }
    
    
}
