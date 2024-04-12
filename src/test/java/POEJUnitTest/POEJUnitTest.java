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
    void testReturnLoginStatus() { // This returns the users login status as well

        POELogin User = new POELogin();

        // Setting the test data to the corresponding variables
        String TestRegisterPass = "Brandon@2005";
        String TestLoginPass = "Brandon@2005";
        String TestLoginUser = "kyl_1";
        String TestRegisterUser = "kyl_1";

        //Calling the right methods so that the test doesnt not give a null error as a result
        User.setsLoginPass(TestLoginPass);
        User.setsRegisterPass(TestLoginPass);
        User.setsLoginName(TestLoginUser);
        User.setsRegisterUser(TestRegisterUser);

        String sExpected = ("Welcome " + User.getsLoginName() + ", " + User.getsLoginLastName() + " it is great to see you again");
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

}
