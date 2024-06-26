/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */

/*
    In text references: 
    1.) According to W3Schools(2023) Arrays are used when multiple values need to be stored in a single variable, instead of declaring separate variables for each value.
        I used arrays to store all the information regarding the tasks so that I can store multiple information in one variable.

    2.) According to satyabrata_jena(2023) You can create objects of arrays. 
        I used the objects of arrays to create multiple instances of arrays that can be used an called when needing to store and manipulate array data

 */
public class DisplayTaskReport {

    // Constant for the maximum number of tasks
    private static final int MAX_TASKS = 100;

    // Arrays to store task details
    private static String[] taskNames = new String[MAX_TASKS]; // Stores the task names
    private static String[] taskIDs = new String[MAX_TASKS];   //Stores the task IDs
    private static String[] devNames = new String[MAX_TASKS];  // Stores the names of developers assigned to tasks
    private static double[] taskDurations = new double[MAX_TASKS]; // Stores the durations of task (in hours)
    private static String[] taskStats = new String[MAX_TASKS]; //Stores the status of the tasks

    private static int taskCount = 0; //Variable to keep track of the number of tasks
    private static int taskAmount = 0; // Variable to count the amount of tasks

    // Method to add a task
    public static void addTasks(String taskName, String devName, double taskDuration, String taskStat) {

        // Ensure the number of tasks does not exceed the maximum allowed
        if (taskCount < MAX_TASKS) {

            // Create a new instance of the task object
            TaskClass task = new TaskClass();

            task.setTaskName(taskName);
            task.setDevName(devName);
            task.setTaskDuration(taskDuration);
            task.setTaskStat(taskStat);
            task.setNumTasks(taskCount + 1);

            // Generate task ID by calling the method
            String taskID = task.createTaskID();

            // Store task details in the corresponding arrays
            taskNames[taskCount] = taskName;
            taskIDs[taskCount] = taskID;
            devNames[taskCount] = devName;
            taskDurations[taskCount] = taskDuration;
            taskStats[taskCount] = taskStat;

            // Increment the task count
            taskCount++;
        } else {
            // Print a message if the maximum number of tasks is reached
            System.out.println("Maximum number of tasks reached");
        }
    }

    //Method to set the task amount
    public static void setTaskAmount(int taskAmount) {
        DisplayTaskReport.taskAmount = taskAmount;
    }

    /*
    In text references: 
    
    1.) According to rishabhprabhu(2023) s StringBuilder in Java is a mutable sequence of characters that is used to create and manipulate strings efficiently. 
        I used the StringBuilder to create strings that can have more inforamtion added on without being overwritten (variables are overwritten if more data is added on). 
        I used it in multiple methods in which I needed to display multiple instances of the arrays so that all the data can be displayed easily.
    
     */
    //Method that generates and prints a report of all the tasks marked as "Done"
    public static String printDoneTasksReport() {

        // Create a new StringBuilder object
        StringBuilder reportBuilder = new StringBuilder();

        // Iterate through all tasks
        for (int i = 0; i < taskCount; i++) {
            // Check if the task is marked as done ("2" indicates done)
            if ((taskStats[i].equalsIgnoreCase("2"))) {

                // Append details of the done task to the report
                if (reportBuilder.length() > 0) {
                    reportBuilder.append("\n");
                }

                //Add the details to the string builder
                reportBuilder.append("Developer: ").append(devNames[i])
                        .append("\nTask Name: ").append(taskNames[i])
                        .append("\nTask Duration: ").append(taskDurations[i]);
            }
        }
        // Return the built report as a string
        return reportBuilder.toString();
    }

    // Method to find and return the task with the longest duration.
    public static String displayLongestDuration() {

        // Initialise variables
        double largestDuration = 0;
        String LongestDuration = "";

        // Iterate through all task durations to find the task with the longest duration
        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > largestDuration) {
                largestDuration = taskDurations[i];

                LongestDuration = devNames[i] + ", " + largestDuration;
            }
        }
        // Return the developer's name and the longest duration
        return LongestDuration;

    }

    // Method that displays the details of a task by taking the the name of the task as input.
    public static String displayTaskName(String taskName) {

        // Iterate through all tasks to find the matching task name
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equals(taskName)) {

                //Return the details of the task if the task is found
                return "Task Name: " + taskNames[i]
                        + "\nDeveloper: " + devNames[i]
                        + "\nTask Status: " + taskStats[i];
            }
        }
        // Return a message if the task is not found
        return "Task not found.";
    }

    /*
    In text references: 
    
    1.) According to W3Schools(2023) the trim() method removes the blankspace (whitespace) from both ends of a string. 
        I used it in multiple methods to make sure that there were no whitespaces when comparing strings. 
        If there are whitespaces when comparing strings then even if the strings being compared are the same, because of the whitespaces it will appear as if the strings are different

     */
    
    // Method that displays all the tasks assigned to a specific developer by taking the name of the developer as input.    
    public static String displayTasksAssigned(String devName) {
        // Create a new StringBuilder object
        StringBuilder reportBuilder = new StringBuilder();

        // Trimming the name of the developer (so that there are no blank spaces that will disrupt the seach). 
        //Also conveting it to lowercase so that if the user searches for the developer using mixed cases,
        //the developer will still show up
        devName = devName.trim().toLowerCase();

        // Iterate through all tasks to find those assigned to the specified developer
        for (int i = 0; i < taskCount; i++) {
            if (devNames[i].trim().equalsIgnoreCase(devName)) {

                //Return the details of the developers task/s if the task/s is found (Used a string builder to accomodate multiple tasks)
                reportBuilder.append("Task Name: ").append(taskNames[i])
                        .append("\nTask Developer: ").append(devNames[i])
                        .append("\nTask Status: ").append(taskStats[i]);
            }
        }

        // Return the built report or a message if no tasks are found
        return reportBuilder.length() > 0 ? reportBuilder.toString() : "No tasks found for the developer.";
    }

    // Method to delete a task by taking the task's name as input
    public static String deleteTasks(String taskName) {

        //Return the details of the task if the task is found
        for (int i = 0; i < taskCount; i++) {

            if (taskNames[i] != null && taskNames[i].equalsIgnoreCase(taskName)) {

                //Nullify the task if the task is found
                taskNames[i] = null;
                taskIDs[i] = null;
                devNames[i] = null;
                taskDurations[i] = 0;
                taskStats[i] = null;
                taskCount--;

                //Return a message to let the user know that the task has been deleted
                return "Task '" + taskName + "' deleted successfully.";
            }
        }
        //Return a message if the task does not exist
        return "Task not found.";
    }

    // Method that displays a report of all the tasks
    public static String displayAllTasks() {
        // Create a new StringBuilder object
        StringBuilder reportBuilder = new StringBuilder();

        // Iterate through all the tasks and append them to the StringBuilder
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i] != null && !taskNames[i].isEmpty()) {
                if (reportBuilder.length() > 0) {

                    // Adding two extra lines so that the tasks can be spaced out neatly
                    reportBuilder.append("\n\n");
                }
                //Accumulating all the details of all the tasks
                reportBuilder.append("Task ID: ").append(taskIDs[i])
                        .append("\nTask Name: ").append(taskNames[i])
                        .append("\nDeveloper: ").append(devNames[i])
                        .append("\nTask Duration: ").append(taskDurations[i])
                        .append("\nTask Status: ").append(taskStats[i]);
            }
        }

        // Returning all the details of all the tasks
        return reportBuilder.toString();
    }

    // Method to reset the task information (used for testing)
    public static void resetTasks() {
        taskCount = 0;
        taskNames = new String[MAX_TASKS];
        taskIDs = new String[MAX_TASKS];
        devNames = new String[MAX_TASKS];
        taskDurations = new double[MAX_TASKS];
        taskStats = new String[MAX_TASKS];
    }

    // Method that returns a developer at a specific point in the array (Used for testing)
    public static String getDevNameAt(int index) {
        if (index >= 0 && index < taskCount) {
            return devNames[index];
        }
        return null;
    }

}

/*
    References:

    rishabhprabhu. 2023. StringBuilder Class in Java with Examples (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/ (Accessed 25 June 2024).

    satyabrata_jena. 2023. How to create array of objects in Java? (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/ (Accessed 25 June 2024).

    W3Schools. 2023. Java Arrays (Version 1.0-SNAPSHOT). [Source code]. https://www.w3schools.com/java/java_arrays.asp (Accessed 25 June 2024).

    W3Schools. 2023. Java String trim() Method (Version 1.0-SNAPSHOT). [Source code]. https://www.w3schools.com/java/ref_string_trim.asp#:~:text=The%20trim()%20method%20removes,not%20change%20the%20original%20string (Accessed 25 June 2024).
*/
