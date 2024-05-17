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

// Returns the total accumulated hours after adding the duration (hours) of the current task
    public double returnTotalHours() {
        hours = hours + getTaskDuration();
        return hours;//Returns the total hours as a double data type
    }

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

// Creates a unique task ID based on task name, number of tasks, and developer's name
    public String createTaskID() {
        String task;
        //Creates the taskID by taking the first 2 characters of the Task Name, adding a semi-colon and then adding on the task number, adding on another semi-colon and then adding on the last three characters of teh developer name
        task = taskName.substring(0, 2) + ":" + Integer.toString(numTasks) + ":" + devName.substring(devName.length() - 3);
        return task.toUpperCase();
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
