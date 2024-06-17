/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
public class TaskClass {

    public int numTasks; // Number of tasks the user wants to enter
    public String taskName; // Name of the task
    public String taskDescription; // Description of the task
    public String devName; // Developer's name
    public double taskDuration; // Duration of the task in hours
    public double totalHours; // Total hours of all tasks combined
    public double hours = 0; // Accumulated hours
    public String taskStat; // Status of the task
    public String taskID; //Task ID

// Setter for totalHours, adds the task duration to the total hours
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours + taskDuration;
    }

// Getter for taskDuration
    public double getTaskDuration() {
        return taskDuration;
    }

// Setter for numTasks
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

// Setter for taskDescription
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

// Setter for devName
    public void setDevName(String devName) {
        this.devName = devName;
    }

// Setter for taskDuration
    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }

// Setter for taskName
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

// Setter for numTasks using Integer type
    public void setNumberOfTasks(Integer numTasks) {
        this.numTasks = numTasks;
    }
    
    

// Checks if the task description length is 50 characters or less
    public boolean checkDescription() {
        if (taskDescription.length() <= 50) {
            return true;
        } else {
            return false;
        }
    }
    
    ////////////////////////////////////////////////

    public int getNumTasks() {
        return numTasks;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDevName() {
        return devName;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getHours() {
        return hours;
    }

    public String getTaskStat() {
        return taskStat;
    }

    public String getTaskID() {
        return taskID;
    }
    
    

// Returns the total accumulated hours after adding the duration (hours) of the current task
    public double returnTotalHours() {
        hours = hours + getTaskDuration();
        return hours;//Returns the total hours as a double data type
    }
     /*
    In text references: 
    
    1.)According to Miglani, G.(2017) a switch statement is statement that executes one statement from multiple inputs/conditions 
    I used the switch statement to set the Status of the Task to one of 3 options, this just seamed more neat and optimised compared to a nested if statement and more convenient

    */

// Sets the task status based on the user input
    public void setTaskStat(String statusInput) {
        int statusChoice = Integer.parseInt(statusInput); //Referece the switch

        switch (statusChoice) {
            case 1:
                taskStat = "To Do"; // Status for tasks that are to be done
                break;
            case 2:
                taskStat = "Done"; // Status for tasks that are completed
                break;
            case 3:
                taskStat = "Doing"; // Status for tasks that are in progress
                break;
        }
    }
    
    /*
    In text references: 
    1.)According to D, G(2018) in order to convert a Integer to a String, the "Integer.toString(Int)" function must be used to convert the Integer data type to a String data type
    I used the .toString(Int) function to convert the number of tasks to a string so that is can be displayed in a JOptionPane to the user.
    
    2.)According to Jenkins, A(2017) the .substring function can be used to capture specific characters from a string and store them.
    I used the .substring method to manipulate the task name and store it so that I could make up the task ID and so that I could capture the last 3 characters of the developers name in order to make the task ID
    
    3.)According to Pandey, N(2018) the .toUpperCase method takes a string and makes all the characters of that string uppercase
    I used the .toUpperCase method to convert the whole of the taskID to upper case so that the ID will be displayed correctly 
    
    */
        

// Creates a unique task ID based on task name, number of tasks, and developer's name
    public String createTaskID() {
        
        //Creates the taskID by taking the first 2 characters of the Task Name, adding a semi-colon and then adding on the task number, adding on another semi-colon and then adding on the last three characters of teh developer name
        taskID = taskName.substring(0, 2) + ":" + Integer.toString(numTasks) + ":" + devName.substring(devName.length() - 3);
        return taskID.toUpperCase();
    }

// Prints the details of the task by printing them out on multiple lines
    public String printTaskDetails() {
        String outputFinal;

        outputFinal = "Task status: " + taskStat + "\nDeveloper details: " + devName + "\nTask Number: " + numTasks + "\nTask Name: " + taskName
                + "\nTask Description: " + taskDescription
                + "\nTask ID: " + createTaskID() + "\nTask Duration: " + getTaskDuration() + " hours";

        return outputFinal; //Returns the output in a string
    }
}


/*
References:

D, G. 2023. How do I convert a String to an int in Java? (Version 1.0-SNAPSHOT). [Source code]. https://sentry.io/answers/how-do-i-convert-a-string-to-an-int-in-java/#:~:text=The%20two%20easiest%20ways%20to,()%20or%20Integer.valueOf()%20 (Accessed 16 May 2023).

Jenkins, A. 2017. Extract first 2 characters of a string in Java. (Version 1.0-SNAPSHOT). [Source code]. https://stackoverflow.com/questions/42217815/extract-first-two-characters-of-a-string-in-java (Accessed 16 May 2023).

Miglani, G. 2017. Switch Statement in Java - GeeksforGeeks. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/switch-statement-in-java/ (Accessed 16 May 2023).

Pandey, N. 2018. Java String toUpperCase() Method With Examples. (Version 1.0-SNAPSHOT). [Source code]. https://www.geeksforgeeks.org/java-string-touppercase-method-with-examples/ (Accessed 16 May 2023).
*/