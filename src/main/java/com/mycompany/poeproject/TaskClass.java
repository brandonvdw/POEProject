/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

import java.util.FormattableFlags;

/**
 *
 * @author brand
 */
public class TaskClass {

    private int numTasks; //Number of tasks the user wants to enter
    private String taskName;
    private String taskDescription;
    private String devName;
    private String devLastName;
    private int taskDuration;

    public int getTaskDuration() {
        return taskDuration;
    }
    private String taskStat;

    
    
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public void setDevLastName(String devLastName) {
        this.devLastName = devLastName;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setNumberOfTasks(Integer numTasks) {
        this.numTasks = numTasks;
    }

    public boolean checkDescription() {
        if (taskDescription.length() <= 50) {
            return true;
        } else {
            return false;
        }

    }

    public void setTaskStat(String taskStat) {
        this.taskStat = taskStat;
    }
    

    public String createTaskID() {

        String task;
        
        task = taskName.substring(0, 2) + ":" + Integer.toString(numTasks) + ":" + devName.substring(devName.length() - 3, devName.length());

        return task.toUpperCase();
    }
    
    
   public String printTaskDetails(){
       
       String outputFinal;
        
       
       outputFinal = "Task status: " + taskStat + "\nDeveloper details: " + devName + " " + devLastName + "\nTask Number: " + numTasks + "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription
               + "\nTask ID: " + createTaskID() + "\nTask Description: " + taskDescription + "\nTask Duration: " + getTaskDuration();
      
       return outputFinal;
   }



    
   

}
