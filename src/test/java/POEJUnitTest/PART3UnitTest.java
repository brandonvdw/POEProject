/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POEJUnitTest;

import com.mycompany.poeproject.DisplayTaskReport;
import com.mycompany.poeproject.TaskClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brand
 */
public class PART3UnitTest {

    @Test
    public void testAddTasksPopulatesDeveloperArray() {
        // Reset the task count and arrays before the test
        DisplayTaskReport.resetTasks();

        // Test data
        String[] developers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
        String taskName = "Sample Task";
        double taskDuration = 1.0;
        String taskStat = "2";

        // Add tasks with the test data
        for (String devName : developers) {
            DisplayTaskReport.addTasks(taskName, devName, taskDuration, taskStat);
        }

        // Assert that the developer array is populated correctly
        for (int i = 0; i < developers.length; i++) {
            assertEquals(developers[i], DisplayTaskReport.getDevNameAt(i));
        }
    }

    @Test
    public void testDisplayLongestDuration() {
        // Reset the task count and arrays before the test
        DisplayTaskReport.resetTasks();

        // Add test data
        DisplayTaskReport.addTasks("Task1", "Mike Smith", 5.0, "2");
        DisplayTaskReport.addTasks("Task2", "Edward Harrington", 7.5, "1");
        DisplayTaskReport.addTasks("Task3", "Samantha Paulson", 3.0, "3");
        DisplayTaskReport.addTasks("Task4", "Glenda Oberholzer", 11.0, "2");

        // Expected result
        String expected = "Glenda Oberholzer, 11.0";

        // Call the method and assert the result
        String actual = DisplayTaskReport.displayLongestDuration();
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayTaskName() {
        // Reset the task count and arrays before the test
        DisplayTaskReport.resetTasks();

        // Add test data for "Create Login" task
        DisplayTaskReport.addTasks("Create Login", "Mike Smith", 5.0, "3");

        // Expected result for the "Create Login" task
        String expectedTask = "Task Name: Create Login\nDeveloper: Mike Smith\nTask Duration: 5.0\nTask Status: 3";

        // Call the method and assert the result
        assertEquals(expectedTask, DisplayTaskReport.displayTaskName("Create Login"));
    }

    @Test
    public void testDisplayTasksAssigned() {
        // Reset the task count and arrays before the test
        DisplayTaskReport.resetTasks();

        // Add test data for multiple tasks
        DisplayTaskReport.addTasks("Create Login", "Mike Smith", 5.0, "2");
        DisplayTaskReport.addTasks("Create Add Features", "Edward Harrison", 8.0, "2");
        DisplayTaskReport.addTasks("Create Reports", "Samantha Paulson", 2.0, "3");
        DisplayTaskReport.addTasks("Add Arrays", "Glenda Oberholzer", 11.0, "1");

        // Expected result for tasks assigned to Samantha Paulson
        String expectedTasksForSamantha = "Task Name: Create Reports\nTask Developer: Samantha Paulson\nTask Status: 3";

        // Call the method and assert the result
        assertEquals(expectedTasksForSamantha, DisplayTaskReport.displayTasksAssigned("Samantha Paulson"));
    }

    @Test
    public void testDeleteTask() {
        // Add tasks for testing
       // Add test data for multiple tasks
        DisplayTaskReport.addTasks("Create Login", "Mike Smith", 5.0, "2");
        DisplayTaskReport.addTasks("Create Add Features", "Edward Harrison", 8.0, "2");
        DisplayTaskReport.addTasks("Create Reports", "Samantha Paulson", 2.0, "3");
        DisplayTaskReport.addTasks("Add Arrays", "Glenda Oberholzer", 11.0, "1");

        // Delete the task "Create Reports"
        String deletionResult = DisplayTaskReport.deleteTasks("Create Reports");

        // Assert the deletion result message
        assertEquals("Task 'Create Reports' deleted successfully.", deletionResult);

    } 
    
    
    @Test
    public void testDisplayAllTasks() {
        // Add tasks for testing
        DisplayTaskReport.addTasks("Create Login", "Mike Smith", 5.0, "2");
       // DisplayTaskReport.addTasks("Create Add Features", "Edward Harrison", 8.0, "2");


        // Expected result after adding tasks
        String expectedTasks = "Task ID: CR:1:ITH\n"
                             + "Task Name: Create Login\n"
                             + "Developer: Mike Smith\n"
                             + "Task Duration: 5.0\n"
                             + "Task Status: 2\n\n";
//                             + "Task ID: 2\n"
//                             + "Task Name: Create Add Features\n"
//                             + "Developer: Edward Harrison\n"
//                             + "Task Duration: 8.0\n"
//                             + "Task Status: 2\n\n"
//                             + "Task ID: 3\n";
             

        // Get all tasks and assert the result
        String actualTasks = DisplayTaskReport.displayAllTasks();
        assertEquals(expectedTasks.trim(), actualTasks.trim());
    }
}

