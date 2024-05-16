/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package POEJUnitTest;

import com.mycompany.poeproject.TaskClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brand
 */
public class PART2UnitTest {

    public PART2UnitTest() {

    }

    @Test
    public void testTaskDesc() {

        TaskClass Task = new TaskClass();
        Task.taskDescription = "Create a Login to authenticate users";
        boolean bActual = Task.checkDescription();
        boolean bExpected = true;
        assertEquals(bExpected, bActual);

    }

    @Test
    public void testValidTaskDesc() {

        TaskClass Task = new TaskClass();
        Task.taskDescription = "Create a Login to authenticate users";
        boolean bActual = Task.checkDescription();
        boolean bExpected = true;
        assertEquals(bExpected, bActual);

    }

    @Test
    public void testInvalidTaskDesc() {

        TaskClass Task = new TaskClass();
        Task.taskDescription = "Create a Login to authenticate users";
        boolean bActual = Task.checkDescription();
        boolean bExpected = false;
        assertNotEquals(bExpected, bActual);

    }

    @Test
    public void testCreateTaskID() {
        TaskClass Task = new TaskClass();
        Task.taskName = "Login Feature";
        Task.numTasks = 0;
        Task.devName = "Robyn Harrison";

        String sExpected = "LO:0:SON";
        String sActual = Task.createTaskID();

        assertEquals(sExpected, sActual);

    }

    @Test
    public void testTotalHours() {
        TaskClass Task = new TaskClass();
        Task.taskDuration = 8;
        double dActual = Task.returnTotalHours();
        double dExpected = 8;

        assertEquals(dExpected, dActual);

    }

    public void testMultipleTotalHours2() {
        TaskClass Task = new TaskClass();
        Task.taskDuration = 10;
        double dActual = Task.returnTotalHours();
        double dExpected = 10;

        assertEquals(dExpected, dActual);

    }
}
